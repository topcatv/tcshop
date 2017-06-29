package com.tcshop.controller;

import com.github.pagehelper.Page;
import com.tcshop.controller.data.Goods;
import com.tcshop.controller.data.ResultData;
import com.tcshop.entity.Product;
import com.tcshop.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取所有product列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Product> data = productService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个product", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "product", value = "添加的product", required = true, dataType = "Goods", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Goods product){
        productService.save(product);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个product", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的product的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "product", value = "更新的product", required = true, dataType = "Goods", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Goods product) {
        productService.update(id, product);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个product")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的product id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Product product = new Product();
        product.setId(id);
        productService.delete(product);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个product")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "product id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();
        Product product = new Product();
        product.setId(id);
        ok.setData(productService.get(product));
        return ok;
    }
}
