package com.tcshop.controller;

import com.tcshop.entity.OrderDetail;
import com.tcshop.service.OrderDetailService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(orderDetailService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个orderDetail", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的orderDetail", required = true, dataType = "OrderDetail", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody OrderDetail orderDetail){
        if(orderDetail != null) {
            if (null == orderDetail.getId()) {
                orderDetailService.save(orderDetail);
            } else {
                orderDetailService.update(orderDetail);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个orderDetail")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的orderDetail id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        orderDetailService.delete(orderDetail);
        return ResultData.ok();
    }
}
