package com.tcshop.service;

import com.tcshop.mapper.FavoriteMapper;
import com.tcshop.entity.Favorite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Favorite服务对象实现类
 */
@Service
@Transactional
public class FavoriteService extends BaseService<Favorite> {
	public static final Logger logger = LoggerFactory.getLogger(FavoriteService.class);
	
	@Autowired
	private FavoriteMapper favoriteMapper;

}
