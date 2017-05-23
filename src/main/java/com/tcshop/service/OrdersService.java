package com.tcshop.service;

import com.tcshop.mapper.OrdersMapper;
import com.tcshop.entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Orders服务对象实现类
 */
@Service
@Transactional
public class OrdersService extends BaseService<Orders> {
	public static final Logger logger = LoggerFactory.getLogger(OrdersService.class);
	
	@Autowired
	private OrdersMapper ordersMapper;

	public void update(Integer id, Orders orders) {
		orders.setId(id);
		ordersMapper.updateByPrimaryKeySelective(orders);
	}
}
