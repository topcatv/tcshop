package com.tcshop.controller;

import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.User;
import com.tcshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;

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
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "15") int pageSize,
                            String name,
                            @RequestParam(value = "createTime[]", required = false) String[] createTime) {
        ResultData ok = ResultData.ok();
        Condition condition = new Condition(User.class);
        if (!StringUtils.isEmpty(name))
            condition.or().andCondition(String.format("LOGIN_NAME LIKE '%s'", name)).andCondition(String.format("USER_NAME LIKE '%%'", name));
        if (createTime!=null&&createTime.length > 0)
            condition.createCriteria().andCondition(String.format("REGISTER_DATE <= '%s' and REGISTER_DATE >= '%s'", createTime[0], createTime[1]));
        ok.setData(userService.selectPageByExample(page, pageSize, condition));
        return ok;
    }

    @ApiOperation(value = "添加一个用户", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加的用户", required = true, dataType = "User", paramType = "body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody User user) {
        userService.register(user);
        return ResultData.ok();
    }

    @ApiOperation(value = "更新一个用户", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "更新的用户", required = true, dataType = "User", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody User user) {
        userService.update(id, user);
        return ResultData.ok();
    }

    @ApiOperation(value = "删除一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的用户id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        userService.delete(user);
        return ResultData.ok();
    }

    @ApiOperation(value = "获取一个用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        User user = new User();
        user.setId(id);
        ok.setData(userService.get(user));
        return ok;
    }

}
