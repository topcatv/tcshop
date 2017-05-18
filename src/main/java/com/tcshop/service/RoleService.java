package com.tcshop.service;

import com.tcshop.mapper.RoleMapper;
import com.tcshop.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Role服务对象实现类
 */
@Service
@Transactional
public class RoleService extends BaseService<Role> {
	public static final Logger logger = LoggerFactory.getLogger(RoleService.class);
	
	@SuppressWarnings("SpringJavaAutowiringInspection")
	@Autowired
	private RoleMapper roleMapper;

	public void update(Integer id, Role role) {
		role.setId(id);
		roleMapper.updateByPrimaryKeySelective(role);
	}
}
