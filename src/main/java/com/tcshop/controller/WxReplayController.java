package com.tcshop.controller;

import com.tcshop.entity.WxReplay;
import com.tcshop.service.WxReplayService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wxReplay")
public class WxReplayController {
    @Autowired
    private WxReplayService wxReplayService;

    @ApiOperation(value = "获取所有wxReplay列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<WxReplay> data = wxReplayService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个wxReplay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wxReplay", value = "添加的wxReplay", required = true, dataType = "WxReplay", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody WxReplay wxReplay){
        wxReplayService.save(wxReplay);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个wxReplay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的wxReplay的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "wxReplay", value = "更新的wxReplay", required = true, dataType = "WxReplay", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody WxReplay wxReplay) {
        wxReplayService.update(id, wxReplay);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个wxReplay")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的wxReplay id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        WxReplay wxReplay = new WxReplay();
        wxReplay.setId(id);
        wxReplayService.delete(wxReplay);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个wxReplay")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "wxReplay id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        WxReplay wxReplay = new WxReplay();
        wxReplay.setId(id);
        ok.setData(wxReplayService.get(wxReplay));
        return ok;
    }
}
