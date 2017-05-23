package com.tcshop.service;

import com.tcshop.mapper.ProductSkuMapper;
import com.tcshop.entity.ProductSku;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProductSku服务对象实现类
 */
@Service
@Transactional
public class ProductSkuService extends BaseService<ProductSku> {
	public static final Logger logger = LoggerFactory.getLogger(ProductSkuService.class);
	
	@Autowired
	private ProductSkuMapper productSkuMapper;

	public void update(Integer id, ProductSku productSku) {
		productSku.setId(id);
		productSkuMapper.updateByPrimaryKeySelective(productSku);
	}
}
