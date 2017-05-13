package com.tcshop.controller;

import com.tcshop.entity.Wxpay;
import com.tcshop.service.WxpayService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wxpay")
public class WxpayController {
    @Autowired
    private WxpayService wxpayService;

    @ApiOperation(value = "获取所有wxpay列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(wxpayService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个wxpay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的wxpay", required = true, dataType = "Wxpay", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Wxpay wxpay){
        if(wxpay != null) {
            if (null == wxpay.getId()) {
                wxpayService.save(wxpay);
            } else {
                wxpayService.update(wxpay);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个wxpay")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的wxpay id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Wxpay wxpay = new Wxpay();
        wxpay.setId(id);
        wxpayService.delete(wxpay);
        return ResultData.ok();
    }
}
