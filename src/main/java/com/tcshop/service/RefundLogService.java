package com.tcshop.service;

import com.tcshop.mapper.RefundLogMapper;
import com.tcshop.entity.RefundLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RefundLog服务对象实现类
 */
@Service
@Transactional
public class RefundLogService extends BaseService<RefundLog> {
	public static final Logger logger = LoggerFactory.getLogger(RefundLogService.class);
	
	@Autowired
	private RefundLogMapper refundLogMapper;

	public void update(Integer id, RefundLog refundLog) {
		refundLog.setId(id);
		refundLogMapper.updateByPrimaryKeySelective(refundLog);
	}
}
