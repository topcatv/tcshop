package com.tcshop.controller;

import com.tcshop.entity.Refund;
import com.tcshop.service.RefundService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(refundService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个refund", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的refund", required = true, dataType = "Refund", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Refund refund){
        if(refund != null) {
            if (null == refund.getId()) {
                refundService.save(refund);
            } else {
                refundService.update(refund);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个refund")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的refund id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Refund refund = new Refund();
        refund.setId(id);
        refundService.delete(refund);
        return ResultData.ok();
    }
}
