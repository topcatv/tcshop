package com.tcshop.service;

import com.tcshop.mapper.OrderLogsMapper;
import com.tcshop.entity.OrderLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderLogs服务对象实现类
 */
@Service
@Transactional
public class OrderLogsService extends BaseService<OrderLogs> {
	public static final Logger logger = LoggerFactory.getLogger(OrderLogsService.class);
	
	@Autowired
	private OrderLogsMapper orderLogsMapper;

}
