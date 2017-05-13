package com.tcshop.service;

import com.tcshop.mapper.WxMenuMapper;
import com.tcshop.entity.WxMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * WxMenu服务对象实现类
 */
@Service
@Transactional
public class WxMenuService extends BaseService<WxMenu> {
	public static final Logger logger = LoggerFactory.getLogger(WxMenuService.class);
	
	@Autowired
	private WxMenuMapper wxMenuMapper;

}
