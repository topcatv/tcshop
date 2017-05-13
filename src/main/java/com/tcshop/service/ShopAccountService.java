package com.tcshop.service;

import com.tcshop.mapper.ShopAccountMapper;
import com.tcshop.entity.ShopAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopAccount服务对象实现类
 */
@Service
@Transactional
public class ShopAccountService extends BaseService<ShopAccount> {
	public static final Logger logger = LoggerFactory.getLogger(ShopAccountService.class);
	
	@Autowired
	private ShopAccountMapper shopAccountMapper;

}
