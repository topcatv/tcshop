package com.tcshop.controller;

import com.tcshop.entity.Permission;
import com.tcshop.service.PermissionService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(permissionService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个permission", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的permission", required = true, dataType = "Permission", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Permission permission){
        if(permission != null) {
            if (null == permission.getId()) {
                permissionService.save(permission);
            } else {
                permissionService.update(permission);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个permission")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的permission id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Permission permission = new Permission();
        permission.setId(id);
        permissionService.delete(permission);
        return ResultData.ok();
    }
}
