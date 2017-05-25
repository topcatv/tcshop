package com.tcshop.controller;

import com.tcshop.entity.ShopAccount;
import com.tcshop.service.ShopAccountService;
import com.github.pagehelper.Page;
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
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<ShopAccount> data = shopAccountService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个shopAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopAccount", value = "添加的shopAccount", required = true, dataType = "ShopAccount", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody ShopAccount shopAccount){
        shopAccountService.save(shopAccount);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个shopAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的shopAccount的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "shopAccount", value = "更新的shopAccount", required = true, dataType = "ShopAccount", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody ShopAccount shopAccount) {
        shopAccountService.update(id, shopAccount);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个shopAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的shopAccount id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        ShopAccount shopAccount = new ShopAccount();
        shopAccount.setId(id);
        shopAccountService.delete(shopAccount);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个shopAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "shopAccount id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        ShopAccount shopAccount = new ShopAccount();
        shopAccount.setId(id);
        ok.setData(shopAccountService.get(shopAccount));
        return ok;
    }
}
