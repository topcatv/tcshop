package com.tcshop.controller;

import com.tcshop.entity.Media;
import com.tcshop.service.MediaService;
import com.github.pagehelper.Page;
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
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Media> data = mediaService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个media", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "media", value = "添加的media", required = true, dataType = "Media", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Media media){
        mediaService.save(media);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个media", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的media的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "media", value = "更新的media", required = true, dataType = "Media", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Media media) {
        mediaService.update(id, media);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个media")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的media id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Media media = new Media();
        media.setId(id);
        mediaService.delete(media);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个media")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "media id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Media media = new Media();
        media.setId(id);
        ok.setData(mediaService.get(media));
        return ok;
    }
}
