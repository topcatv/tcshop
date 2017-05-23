package com.tcshop.controller;

import com.tcshop.entity.WxMenu;
import com.tcshop.service.WxMenuService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wxMenu")
public class WxMenuController {
    @Autowired
    private WxMenuService wxMenuService;

    @ApiOperation(value = "获取所有wxMenu列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<WxMenu> data = wxMenuService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个wxMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wxMenu", value = "添加的wxMenu", required = true, dataType = "WxMenu", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody WxMenu wxMenu){
        wxMenuService.save(wxMenu);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个wxMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的wxMenu的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "wxMenu", value = "更新的wxMenu", required = true, dataType = "WxMenu", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody WxMenu wxMenu) {
        wxMenuService.update(id, wxMenu);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个wxMenu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的wxMenu id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        WxMenu wxMenu = new WxMenu();
        wxMenu.setId(id);
        wxMenuService.delete(wxMenu);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个wxMenu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "wxMenu id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        WxMenu wxMenu = new WxMenu();
        wxMenu.setId(id);
        ok.setData(wxMenuService.get(wxMenu));
        return ok;
    }
}
