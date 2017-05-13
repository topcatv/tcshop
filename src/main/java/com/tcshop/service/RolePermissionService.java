package com.tcshop.service;

import com.tcshop.mapper.RolePermissionMapper;
import com.tcshop.entity.RolePermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RolePermission服务对象实现类
 */
@Service
@Transactional
public class RolePermissionService extends BaseService<RolePermission> {
	public static final Logger logger = LoggerFactory.getLogger(RolePermissionService.class);
	
	@Autowired
	private RolePermissionMapper rolePermissionMapper;

}
