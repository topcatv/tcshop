package com.tcshop.service;

import com.tcshop.mapper.UserPermissionMapper;
import com.tcshop.entity.UserPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserPermission服务对象实现类
 */
@Service
@Transactional
public class UserPermissionService extends BaseService<UserPermission> {
	public static final Logger logger = LoggerFactory.getLogger(UserPermissionService.class);
	
	@Autowired
	private UserPermissionMapper userPermissionMapper;
}
