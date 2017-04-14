package com.tcshop.controller;

import com.tcshop.entity.User;
import com.tcshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liuyi on 2017/3/31.
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> all() {
        return userService.selectPage(1, 10);
    }

}
