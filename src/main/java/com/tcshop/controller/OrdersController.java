package com.tcshop.controller;

import com.tcshop.entity.Orders;
import com.tcshop.service.OrdersService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(ordersService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个orders", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的orders", required = true, dataType = "Orders", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Orders orders){
        if(orders != null) {
            if (null == orders.getId()) {
                ordersService.save(orders);
            } else {
                ordersService.update(orders);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个orders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的orders id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Orders orders = new Orders();
        orders.setId(id);
        ordersService.delete(orders);
        return ResultData.ok();
    }
}
