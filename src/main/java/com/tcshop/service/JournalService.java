package com.tcshop.service;

import com.tcshop.mapper.JournalMapper;
import com.tcshop.entity.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Journal服务对象实现类
 */
@Service
@Transactional
public class JournalService extends BaseService<Journal> {
	public static final Logger logger = LoggerFactory.getLogger(JournalService.class);
	
	@Autowired
	private JournalMapper journalMapper;

}
