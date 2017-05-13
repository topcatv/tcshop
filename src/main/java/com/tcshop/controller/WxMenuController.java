package com.tcshop.controller;

import com.tcshop.entity.WxMenu;
import com.tcshop.service.WxMenuService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(wxMenuService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个wxMenu", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的wxMenu", required = true, dataType = "WxMenu", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody WxMenu wxMenu){
        if(wxMenu != null) {
            if (null == wxMenu.getId()) {
                wxMenuService.save(wxMenu);
            } else {
                wxMenuService.update(wxMenu);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个wxMenu")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的wxMenu id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        WxMenu wxMenu = new WxMenu();
        wxMenu.setId(id);
        wxMenuService.delete(wxMenu);
        return ResultData.ok();
    }
}
