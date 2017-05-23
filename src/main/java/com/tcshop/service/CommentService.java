package com.tcshop.service;

import com.tcshop.mapper.CommentMapper;
import com.tcshop.entity.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Comment服务对象实现类
 */
@Service
@Transactional
public class CommentService extends BaseService<Comment> {
	public static final Logger logger = LoggerFactory.getLogger(CommentService.class);
	
	@Autowired
	private CommentMapper commentMapper;

	public void update(Integer id, Comment comment) {
		comment.setId(id);
		commentMapper.updateByPrimaryKeySelective(comment);
	}
}
