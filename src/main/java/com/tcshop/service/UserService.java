package com.tcshop.service;

import com.tcshop.entity.Users;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by liuyi on 2017/3/31.
 */
@Service
@Transactional
public class UserService extends BaseService<Users> {

    public Users findUserByName(String username) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo("username", username);
        List<Users> users = mapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(users) ? users.get(0) : null;
    }
}
