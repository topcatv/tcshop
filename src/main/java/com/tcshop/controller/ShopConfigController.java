package com.tcshop.controller;

import com.tcshop.entity.ShopConfig;
import com.tcshop.service.ShopConfigService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shopConfig")
public class ShopConfigController {
    @Autowired
    private ShopConfigService shopConfigService;

    @ApiOperation(value = "获取所有shopConfig列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<ShopConfig> data = shopConfigService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个shopConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "shopConfig", value = "添加的shopConfig", required = true, dataType = "ShopConfig", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody ShopConfig shopConfig){
        shopConfigService.save(shopConfig);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个shopConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的shopConfig的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "shopConfig", value = "更新的shopConfig", required = true, dataType = "ShopConfig", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody ShopConfig shopConfig) {
        shopConfigService.update(id, shopConfig);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个shopConfig")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的shopConfig id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        ShopConfig shopConfig = new ShopConfig();
        shopConfig.setId(id);
        shopConfigService.delete(shopConfig);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个shopConfig")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "shopConfig id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        ShopConfig shopConfig = new ShopConfig();
        shopConfig.setId(id);
        ok.setData(shopConfigService.get(shopConfig));
        return ok;
    }
}
