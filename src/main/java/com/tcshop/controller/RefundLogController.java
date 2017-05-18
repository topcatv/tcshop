package com.tcshop.controller;

import com.tcshop.entity.RefundLog;
import com.tcshop.service.RefundLogService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/refundLog")
public class RefundLogController {
    @Autowired
    private RefundLogService refundLogService;

    @ApiOperation(value = "获取所有refundLog列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(refundLogService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个refundLog", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的refundLog", required = true, dataType = "RefundLog", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody RefundLog refundLog){
        if(refundLog != null) {
            if (null == refundLog.getId()) {
                refundLogService.save(refundLog);
            } else {
                refundLogService.update(refundLog);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个refundLog")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的refundLog id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        RefundLog refundLog = new RefundLog();
        refundLog.setId(id);
        refundLogService.delete(refundLog);
        return ResultData.ok();
    }
}