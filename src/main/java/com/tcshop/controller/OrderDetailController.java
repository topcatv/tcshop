package com.tcshop.controller;

import com.tcshop.entity.OrderDetail;
import com.tcshop.service.OrderDetailService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @ApiOperation(value = "获取所有orderDetail列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<OrderDetail> data = orderDetailService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个orderDetail", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderDetail", value = "添加的orderDetail", required = true, dataType = "OrderDetail", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody OrderDetail orderDetail){
        orderDetailService.save(orderDetail);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个orderDetail", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的orderDetail的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "orderDetail", value = "更新的orderDetail", required = true, dataType = "OrderDetail", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody OrderDetail orderDetail) {
        orderDetailService.update(id, orderDetail);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个orderDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的orderDetail id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetailService.delete(orderDetail);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个orderDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "orderDetail id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        ok.setData(orderDetailService.get(orderDetail));
        return ok;
    }
}
