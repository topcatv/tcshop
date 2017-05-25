package com.tcshop.controller;

import com.tcshop.entity.Refund;
import com.tcshop.service.RefundService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/refund")
public class RefundController {
    @Autowired
    private RefundService refundService;

    @ApiOperation(value = "获取所有refund列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Refund> data = refundService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个refund", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "refund", value = "添加的refund", required = true, dataType = "Refund", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Refund refund){
        refundService.save(refund);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个refund", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的refund的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "refund", value = "更新的refund", required = true, dataType = "Refund", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Refund refund) {
        refundService.update(id, refund);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个refund")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的refund id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Refund refund = new Refund();
        refund.setId(id);
        refundService.delete(refund);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个refund")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "refund id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Refund refund = new Refund();
        refund.setId(id);
        ok.setData(refundService.get(refund));
        return ok;
    }
}
