package com.tcshop.service;

import com.tcshop.mapper.WxpayMapper;
import com.tcshop.entity.Wxpay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Wxpay服务对象实现类
 */
@Service
@Transactional
public class WxpayService extends BaseService<Wxpay> {
	public static final Logger logger = LoggerFactory.getLogger(WxpayService.class);
	
	@Autowired
	private WxpayMapper wxpayMapper;

}
