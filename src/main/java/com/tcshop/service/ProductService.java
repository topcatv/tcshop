package com.tcshop.service;

import com.google.common.collect.Lists;
import com.tcshop.controller.data.Goods;
import com.tcshop.entity.Product;
import com.tcshop.entity.ProductSku;
import com.tcshop.mapper.ProductMapper;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Product服务对象实现类
 */
@Service
@Transactional
public class ProductService extends BaseService<Product> {
	public static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Resource
	private ProductMapper productMapper;
	@Resource
	private ProductSkuService productSkuService;

	public void update(Integer id, Product product) {
		product.setId(id);
		productMapper.updateByPrimaryKeySelective(product);
	}

	public void save(Goods good) {
		super.save(good);
		List<ProductSku> productSku = getSku(good);
		productSkuService.save(productSku);
	}

	public Goods get(Product product) {
		Goods goods = new Goods();
		Product p = super.get(product);
		try {
			PropertyUtils.copyProperties(goods, p);
			List<ProductSku> skus = productSkuService.queryByProductId(p.getId());
			if(CollectionUtils.isNotEmpty(skus)) {
				ArrayList<String> goodsName = Lists.newArrayList();
				ArrayList<Long> goodsPrice = Lists.newArrayList();
				ArrayList<Integer> goodsStock = Lists.newArrayList();
				for (ProductSku productSku : skus) {
					goodsName.add(productSku.getName());
					goodsPrice.add(productSku.getPrice());
					goodsStock.add(productSku.getStock());
				}
				goods.setGoodsName(goodsName.toArray(new String[]{}));
				goods.setGoodsPrice(goodsPrice.toArray(new Long[]{}));
				goods.setGoodsStock(goodsStock.toArray(new Integer[]{}));
			}
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return goods;
	}

	private List<ProductSku> getSku(Goods good) {
		List<ProductSku> productSkus = Lists.newArrayList();
		String[] goodsName = good.getGoodsName();
		Long[] goodsPrice = good.getGoodsPrice();
		Integer[] goodsStock = good.getGoodsStock();
		if(ArrayUtils.isNotEmpty(goodsName)) {
			for (int i = 0; i < goodsName.length; i++) {
				ProductSku productSku = new ProductSku();
				productSku.setProductId(good.getId());
				productSku.setName(goodsName[i]);
				productSku.setPrice(goodsPrice[i]);
				productSku.setStock(goodsStock[i]);
				productSkus.add(productSku);
			}
		}
		return productSkus;
	}
}
