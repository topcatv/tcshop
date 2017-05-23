package com.tcshop.service;

import com.tcshop.mapper.ProductMapper;
import com.tcshop.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Product服务对象实现类
 */
@Service
@Transactional
public class ProductService extends BaseService<Product> {
	public static final Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductMapper productMapper;

	public void update(Integer id, Product product) {
		product.setId(id);
		productMapper.updateByPrimaryKeySelective(product);
	}
}
