package com.tcshop.controller;

import com.tcshop.entity.ShopAccount;
import com.tcshop.service.ShopAccountService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shopAccount")
public class ShopAccountController {
    @Autowired
    private ShopAccountService shopAccountService;

    @ApiOperation(value = "获取所有shopAccount列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(shopAccountService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个shopAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的shopAccount", required = true, dataType = "ShopAccount", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody ShopAccount shopAccount){
        if(shopAccount != null) {
            if (null == shopAccount.getId()) {
                shopAccountService.save(shopAccount);
            } else {
                shopAccountService.update(shopAccount);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个shopAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的shopAccount id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        ShopAccount shopAccount = new ShopAccount();
        shopAccount.setId(id);
        shopAccountService.delete(shopAccount);
        return ResultData.ok();
    }
}
