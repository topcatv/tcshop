package com.tcshop.controller;

import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.Role;
import com.tcshop.service.RoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "获取所有role列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Role> data = roleService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }

    @ApiOperation(value = "添加一个role", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "role", value = "添加的role", required = true, dataType = "Role", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Role role){
            roleService.save(role);
            return ResultData.ok();
    }

    @ApiOperation(value = "更新一个role", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的role的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "role", value = "更新的role", required = true, dataType = "Role", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Role role) {
        roleService.update(id, role);
        return ResultData.ok();
    }

    @ApiOperation(value = "删除一个role")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的role id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Role role = new Role();
        role.setId(id);
        roleService.delete(role);
        return ResultData.ok();
    }

    @ApiOperation(value = "获取一个role")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "role id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Role role = new Role();
        role.setId(id);
        ok.setData(roleService.get(role));
        return ok;
    }
}
