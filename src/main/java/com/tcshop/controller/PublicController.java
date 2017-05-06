package com.tcshop.controller;

import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by topcat on 2017/5/6.
 */
@RestController
public class PublicController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultData currentUser() {
//        return (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
        User user = new User();
        user.setLoginName("admin");
        user.setUserName("admin");
        ResultData ok = ResultData.ok();
        ok.setData(user);
        return ok;
    }
}
