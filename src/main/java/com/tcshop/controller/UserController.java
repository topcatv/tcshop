package com.tcshop.controller;

import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.User;
import com.tcshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liuyi on 2017/3/31.
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户服务接口")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取所有用户列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(userService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个用户", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的用户", required = true, dataType = "User", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody User user){
        if(user != null) {
            if (null == user.getId()) {
                userService.save(user);
            } else {
                userService.update(user);
            }
        }
        return ResultData.ok();
    }

    @ApiOperation(value = "删除一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的用户id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return ResultData.ok();
    }

    @ApiOperation(value = "获取一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id){
        ResultData ok = ResultData.ok();

        User user = new User();
        user.setId(id);
        ok.setData(userService.get(user));
        return ok;
    }

}
