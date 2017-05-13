package com.tcshop.controller;

import com.tcshop.entity.Custormer;
import com.tcshop.service.CustormerService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/custormer")
public class CustormerController {
    @Autowired
    private CustormerService custormerService;

    @ApiOperation(value = "获取所有custormer列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(custormerService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个custormer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的custormer", required = true, dataType = "Custormer", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Custormer custormer){
        if(custormer != null) {
            if (null == custormer.getId()) {
                custormerService.save(custormer);
            } else {
                custormerService.update(custormer);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个custormer")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的custormer id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Custormer custormer = new Custormer();
        custormer.setId(id);
        custormerService.delete(custormer);
        return ResultData.ok();
    }
}
