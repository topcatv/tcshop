package com.tcshop.controller;

import com.tcshop.entity.WxReplay;
import com.tcshop.service.WxReplayService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(wxReplayService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个wxReplay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的wxReplay", required = true, dataType = "WxReplay", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody WxReplay wxReplay){
        if(wxReplay != null) {
            if (null == wxReplay.getId()) {
                wxReplayService.save(wxReplay);
            } else {
                wxReplayService.update(wxReplay);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个wxReplay")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的wxReplay id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        WxReplay wxReplay = new WxReplay();
        wxReplay.setId(id);
        wxReplayService.delete(wxReplay);
        return ResultData.ok();
    }
}
