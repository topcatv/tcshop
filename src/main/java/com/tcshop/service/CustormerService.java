package com.tcshop.service;

import com.tcshop.mapper.CustormerMapper;
import com.tcshop.entity.Custormer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Custormer服务对象实现类
 */
@Service
@Transactional
public class CustormerService extends BaseService<Custormer> {
	public static final Logger logger = LoggerFactory.getLogger(CustormerService.class);
	
	@Autowired
	private CustormerMapper custormerMapper;

	public void update(Integer id, Custormer custormer) {
		custormer.setId(id);
		custormerMapper.updateByPrimaryKeySelective(custormer);
	}
}
