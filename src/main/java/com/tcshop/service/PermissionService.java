package com.tcshop.service;

import com.tcshop.mapper.PermissionMapper;
import com.tcshop.entity.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Permission服务对象实现类
 */
@Service
@Transactional
public class PermissionService extends BaseService<Permission> {
	public static final Logger logger = LoggerFactory.getLogger(PermissionService.class);
	
	@Autowired
	private PermissionMapper permissionMapper;

}
