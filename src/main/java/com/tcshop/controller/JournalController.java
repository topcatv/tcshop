package com.tcshop.controller;

import com.tcshop.entity.Journal;
import com.tcshop.service.JournalService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(journalService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个journal", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的journal", required = true, dataType = "Journal", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Journal journal){
        if(journal != null) {
            if (null == journal.getId()) {
                journalService.save(journal);
            } else {
                journalService.update(journal);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个journal")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的journal id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Journal journal = new Journal();
        journal.setId(id);
        journalService.delete(journal);
        return ResultData.ok();
    }
}
