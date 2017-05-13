package com.tcshop.controller;

import com.tcshop.entity.ShopConfig;
import com.tcshop.service.ShopConfigService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(shopConfigService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个shopConfig", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的shopConfig", required = true, dataType = "ShopConfig", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody ShopConfig shopConfig){
        if(shopConfig != null) {
            if (null == shopConfig.getId()) {
                shopConfigService.save(shopConfig);
            } else {
                shopConfigService.update(shopConfig);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个shopConfig")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的shopConfig id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        ShopConfig shopConfig = new ShopConfig();
        shopConfig.setId(id);
        shopConfigService.delete(shopConfig);
        return ResultData.ok();
    }
}
