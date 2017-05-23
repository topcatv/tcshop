package com.tcshop.controller;

import com.tcshop.entity.Wxpay;
import com.tcshop.service.WxpayService;
import com.github.pagehelper.Page;
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
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Wxpay> data = wxpayService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个wxpay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "wxpay", value = "添加的wxpay", required = true, dataType = "Wxpay", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Wxpay wxpay){
        wxpayService.save(wxpay);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个wxpay", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的wxpay的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "wxpay", value = "更新的wxpay", required = true, dataType = "Wxpay", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Wxpay wxpay) {
        wxpayService.update(id, wxpay);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个wxpay")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的wxpay id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Wxpay wxpay = new Wxpay();
        wxpay.setId(id);
        wxpayService.delete(wxpay);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个wxpay")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "wxpay id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Wxpay wxpay = new Wxpay();
        wxpay.setId(id);
        ok.setData(wxpayService.get(wxpay));
        return ok;
    }
}
