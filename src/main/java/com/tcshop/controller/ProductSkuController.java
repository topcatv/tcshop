package com.tcshop.controller;

import com.tcshop.entity.ProductSku;
import com.tcshop.service.ProductSkuService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/productSku")
public class ProductSkuController {
    @Autowired
    private ProductSkuService productSkuService;

    @ApiOperation(value = "获取所有productSku列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(productSkuService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个productSku", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的productSku", required = true, dataType = "ProductSku", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody ProductSku productSku){
        if(productSku != null) {
            if (null == productSku.getId()) {
                productSkuService.save(productSku);
            } else {
                productSkuService.update(productSku);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个productSku")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的productSku id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        ProductSku productSku = new ProductSku();
        productSku.setId(id);
        productSkuService.delete(productSku);
        return ResultData.ok();
    }
}
