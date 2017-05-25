package com.tcshop.controller;

import com.tcshop.entity.Cart;
import com.tcshop.service.CartService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @ApiOperation(value = "获取所有cart列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Cart> data = cartService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个cart", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cart", value = "添加的cart", required = true, dataType = "Cart", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Cart cart){
        cartService.save(cart);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个cart", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的cart的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "cart", value = "更新的cart", required = true, dataType = "Cart", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Cart cart) {
        cartService.update(id, cart);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个cart")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的cart id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Cart cart = new Cart();
        cart.setId(id);
        cartService.delete(cart);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个cart")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "cart id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Cart cart = new Cart();
        cart.setId(id);
        ok.setData(cartService.get(cart));
        return ok;
    }
}
