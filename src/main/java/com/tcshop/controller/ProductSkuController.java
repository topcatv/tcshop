package com.tcshop.controller;

import com.tcshop.entity.ProductSku;
import com.tcshop.service.ProductSkuService;
import com.github.pagehelper.Page;
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
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<ProductSku> data = productSkuService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个productSku", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productSku", value = "添加的productSku", required = true, dataType = "ProductSku", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody ProductSku productSku){
        productSkuService.save(productSku);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个productSku", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的productSku的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "productSku", value = "更新的productSku", required = true, dataType = "ProductSku", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody ProductSku productSku) {
        productSkuService.update(id, productSku);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个productSku")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的productSku id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        ProductSku productSku = new ProductSku();
        productSku.setId(id);
        productSkuService.delete(productSku);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个productSku")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "productSku id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        ProductSku productSku = new ProductSku();
        productSku.setId(id);
        ok.setData(productSkuService.get(productSku));
        return ok;
    }
}
