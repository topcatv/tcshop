package com.tcshop.service;

import com.tcshop.mapper.CategoryMapper;
import com.tcshop.entity.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Category服务对象实现类
 */
@Service
@Transactional
public class CategoryService extends BaseService<Category> {
	public static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private CategoryMapper categoryMapper;

}
