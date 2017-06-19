package com.tcshop.controller;

import com.tcshop.entity.Journal;
import com.tcshop.service.JournalService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalService journalService;

    @ApiOperation(value = "获取所有journal列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Journal> data = journalService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个journal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "journal", value = "添加的journal", required = true, dataType = "Journal", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Journal journal){
        journalService.save(journal);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个journal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的journal的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "journal", value = "更新的journal", required = true, dataType = "Journal", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Journal journal) {
        journalService.update(id, journal);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个journal")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的journal id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Journal journal = new Journal();
        journal.setId(id);
        journalService.delete(journal);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个journal")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "journal id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Journal journal = new Journal();
        journal.setId(id);
        ok.setData(journalService.get(journal));
        return ok;
    }
}
