package com.tcshop.service;

import com.tcshop.mapper.RefundMapper;
import com.tcshop.entity.Refund;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Refund服务对象实现类
 */
@Service
@Transactional
public class RefundService extends BaseService<Refund> {
	public static final Logger logger = LoggerFactory.getLogger(RefundService.class);
	
	@Autowired
	private RefundMapper refundMapper;

}
