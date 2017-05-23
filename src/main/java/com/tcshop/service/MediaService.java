package com.tcshop.service;

import com.tcshop.mapper.MediaMapper;
import com.tcshop.entity.Media;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Media服务对象实现类
 */
@Service
@Transactional
public class MediaService extends BaseService<Media> {
	public static final Logger logger = LoggerFactory.getLogger(MediaService.class);
	
	@Autowired
	private MediaMapper mediaMapper;

	public void update(Integer id, Media media) {
		media.setId(id);
		mediaMapper.updateByPrimaryKeySelective(media);
	}
}
