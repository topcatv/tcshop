package com.tcshop.service;

import com.tcshop.mapper.BrandMapper;
import com.tcshop.entity.Brand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Brand服务对象实现类
 */
@Service
@Transactional
public class BrandService extends BaseService<Brand> {
	public static final Logger logger = LoggerFactory.getLogger(BrandService.class);
	
	@Autowired
	private BrandMapper brandMapper;

	public void update(Integer id, Brand brand) {
		brand.setId(id);
		brandMapper.updateByPrimaryKeySelective(brand);
	}
}
