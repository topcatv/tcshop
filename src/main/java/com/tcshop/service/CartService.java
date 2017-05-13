package com.tcshop.service;

import com.tcshop.mapper.CartMapper;
import com.tcshop.entity.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Cart服务对象实现类
 */
@Service
@Transactional
public class CartService extends BaseService<Cart> {
	public static final Logger logger = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	private CartMapper cartMapper;

}
