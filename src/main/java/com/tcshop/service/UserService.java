package com.tcshop.service;

import com.tcshop.entity.User;
import com.tcshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by topcat on 2017/4/13.
 */
@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

    public User findByLoginName(String loginName){
        User u = new User();
        u.setLoginName(loginName);
        return userMapper.selectOne(u);
    }
}
