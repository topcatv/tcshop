package com.tcshop.service;

import com.tcshop.mapper.ShopConfigMapper;
import com.tcshop.entity.ShopConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ShopConfig服务对象实现类
 */
@Service
@Transactional
public class ShopConfigService extends BaseService<ShopConfig> {
	public static final Logger logger = LoggerFactory.getLogger(ShopConfigService.class);
	
	@Autowired
	private ShopConfigMapper shopConfigMapper;

}
