package com.tcshop.controller;

import com.tcshop.entity.Orders;
import com.tcshop.service.OrdersService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @ApiOperation(value = "获取所有orders列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Orders> data = ordersService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orders", value = "添加的orders", required = true, dataType = "Orders", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Orders orders){
        ordersService.save(orders);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的orders的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "orders", value = "更新的orders", required = true, dataType = "Orders", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Orders orders) {
        ordersService.update(id, orders);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个orders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的orders id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Orders orders = new Orders();
        orders.setId(id);
        ordersService.delete(orders);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个orders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "orders id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Orders orders = new Orders();
        orders.setId(id);
        ok.setData(ordersService.get(orders));
        return ok;
    }
}
