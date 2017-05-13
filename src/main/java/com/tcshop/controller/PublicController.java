package com.tcshop.controller;

import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.User;
import com.tcshop.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by topcat on 2017/5/6.
 */
@RestController
public class PublicController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResultData currentUser() {
        ResultData ok = ResultData.ok();
        ok.setData(SecurityUtils.getSubject().getPrincipal());
        return ok;
    }

    @ApiOperation(value = "用户注册", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "注册的用户", required = true, dataType = "User", paramType="body")
    })
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData register(@RequestBody User user) {
        userService.register(user);
        return ResultData.ok();
    }
}
