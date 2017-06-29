package com.tcshop.service;

import com.tcshop.entity.Category;
import com.tcshop.mapper.ProductSkuMapper;
import com.tcshop.entity.ProductSku;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import java.util.List;

/**
 * ProductSku服务对象实现类
 */
@Service
@Transactional
public class ProductSkuService extends BaseService<ProductSku> {
	public static final Logger logger = LoggerFactory.getLogger(ProductSkuService.class);
	
	@Resource
	private ProductSkuMapper productSkuMapper;

	public void update(Integer id, ProductSku productSku) {
		productSku.setId(id);
		productSkuMapper.updateByPrimaryKeySelective(productSku);
	}

	public void save(List<ProductSku> productSku) {
		productSkuMapper.insertList(productSku);
	}

	public List<ProductSku> queryByProductId(Integer id) {
		Condition condition = new Condition(ProductSku.class);
		condition.createCriteria().andEqualTo("productId", id);
		return productSkuMapper.selectByExample(condition);
	}
}
