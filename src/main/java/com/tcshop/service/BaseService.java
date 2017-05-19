package com.tcshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tcshop.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseService<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int update(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int delete(T entity) {
        return mapper.deleteByPrimaryKey(entity);
    }

    public T get(T entity) {
        return mapper.selectByPrimaryKey(entity);
    }

    /**
     * 单表分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<T> selectPage(int pageNum, int pageSize) {
        //Spring4支持泛型注入
        return PageHelper.startPage(pageNum, pageSize).doSelectPage(()-> mapper.select(null));
    }
}