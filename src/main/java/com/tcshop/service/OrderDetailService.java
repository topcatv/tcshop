package com.tcshop.service;

import com.tcshop.mapper.OrderDetailMapper;
import com.tcshop.entity.OrderDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * OrderDetail服务对象实现类
 */
@Service
@Transactional
public class OrderDetailService extends BaseService<OrderDetail> {
	public static final Logger logger = LoggerFactory.getLogger(OrderDetailService.class);
	
	@Autowired
	private OrderDetailMapper orderDetailMapper;

	public void update(Integer id, OrderDetail orderDetail) {
		orderDetail.setId(id);
		orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
	}
}
