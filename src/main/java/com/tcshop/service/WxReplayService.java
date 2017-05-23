package com.tcshop.service;

import com.tcshop.mapper.WxReplayMapper;
import com.tcshop.entity.WxReplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * WxReplay服务对象实现类
 */
@Service
@Transactional
public class WxReplayService extends BaseService<WxReplay> {
	public static final Logger logger = LoggerFactory.getLogger(WxReplayService.class);
	
	@Autowired
	private WxReplayMapper wxReplayMapper;

	public void update(Integer id, WxReplay wxReplay) {
		wxReplay.setId(id);
		wxReplayMapper.updateByPrimaryKeySelective(wxReplay);
	}
}
