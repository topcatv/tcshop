package com.tcshop.service;

import com.tcshop.mapper.CustormAccountMapper;
import com.tcshop.entity.CustormAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CustormAccount服务对象实现类
 */
@Service
@Transactional
public class CustormAccountService extends BaseService<CustormAccount> {
	public static final Logger logger = LoggerFactory.getLogger(CustormAccountService.class);
	
	@Autowired
	private CustormAccountMapper custormAccountMapper;

	public void update(Integer id, CustormAccount custormAccount) {
		custormAccount.setId(id);
		custormAccountMapper.updateByPrimaryKeySelective(custormAccount);
	}
}
