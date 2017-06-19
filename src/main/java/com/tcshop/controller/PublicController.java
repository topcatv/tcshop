package com.tcshop.controller;

import com.qiniu.util.Auth;
import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.User;
import com.tcshop.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by topcat on 2017/5/6.
 */
@RestController
public class PublicController {

    @Autowired
    private UserService userService;

    @Value("${qiniu.ak}")
    private String qnAk;

    @Value("${qiniu.sk}")
    private String qnSk;

    @Value("${qiniu.bucket}")
    private String bucket;



    @RequestMapping(value = "/current_user", method = RequestMethod.GET)
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

    @GetMapping("/qiniu/uptoken")
    public ResultData qiniuUpToken(String ns){
        Auth auth = Auth.create(qnAk, qnSk);
        String uploadKey = String.format("%s/%s", ns, StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
        String upToken = auth.uploadToken(bucket, uploadKey);
        ResultData ok = ResultData.ok();
        ok.setData(upToken);
        ok.put("uploadKey", uploadKey);
        return ok;
    }
}
