package com.tcshop.controller;

import com.tcshop.entity.Permission;
import com.tcshop.service.PermissionService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取所有permission列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Permission> data = permissionService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个permission", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "permission", value = "添加的permission", required = true, dataType = "Permission", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Permission permission){
        permissionService.save(permission);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个permission", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的permission的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "permission", value = "更新的permission", required = true, dataType = "Permission", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Permission permission) {
        permissionService.update(id, permission);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个permission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的permission id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Permission permission = new Permission();
        permission.setId(id);
        permissionService.delete(permission);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个permission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "permission id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Permission permission = new Permission();
        permission.setId(id);
        ok.setData(permissionService.get(permission));
        return ok;
    }
}
