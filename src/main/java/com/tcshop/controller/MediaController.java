package com.tcshop.controller;

import com.tcshop.entity.Media;
import com.tcshop.service.MediaService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @ApiOperation(value = "获取所有media列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(mediaService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个media", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的media", required = true, dataType = "Media", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Media media){
        if(media != null) {
            if (null == media.getId()) {
                mediaService.save(media);
            } else {
                mediaService.update(media);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个media")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的media id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Media media = new Media();
        media.setId(id);
        mediaService.delete(media);
        return ResultData.ok();
    }
}
