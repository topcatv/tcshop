package com.tcshop.service;

import com.tcshop.mapper.CategoryProductMapper;
import com.tcshop.entity.CategoryProduct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CategoryProduct服务对象实现类
 */
@Service
@Transactional
public class CategoryProductService extends BaseService<CategoryProduct> {
	public static final Logger logger = LoggerFactory.getLogger(CategoryProductService.class);
	
	@Autowired
	private CategoryProductMapper categoryProductMapper;

}
