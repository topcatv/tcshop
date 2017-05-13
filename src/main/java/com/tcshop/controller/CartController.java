package com.tcshop.controller;

import com.tcshop.entity.Cart;
import com.tcshop.service.CartService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(cartService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个cart", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的cart", required = true, dataType = "Cart", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Cart cart){
        if(cart != null) {
            if (null == cart.getId()) {
                cartService.save(cart);
            } else {
                cartService.update(cart);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个cart")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的cart id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Cart cart = new Cart();
        cart.setId(id);
        cartService.delete(cart);
        return ResultData.ok();
    }
}
