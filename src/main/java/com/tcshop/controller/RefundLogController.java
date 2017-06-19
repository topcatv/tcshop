package com.tcshop.controller;

import com.tcshop.entity.RefundLog;
import com.tcshop.service.RefundLogService;
import com.github.pagehelper.Page;
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
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<RefundLog> data = refundLogService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个refundLog", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "refundLog", value = "添加的refundLog", required = true, dataType = "RefundLog", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody RefundLog refundLog){
        refundLogService.save(refundLog);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个refundLog", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的refundLog的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "refundLog", value = "更新的refundLog", required = true, dataType = "RefundLog", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody RefundLog refundLog) {
        refundLogService.update(id, refundLog);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个refundLog")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的refundLog id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        RefundLog refundLog = new RefundLog();
        refundLog.setId(id);
        refundLogService.delete(refundLog);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个refundLog")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "refundLog id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        RefundLog refundLog = new RefundLog();
        refundLog.setId(id);
        ok.setData(refundLogService.get(refundLog));
        return ok;
    }
}
