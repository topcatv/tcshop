package com.tcshop.controller;

import com.tcshop.entity.Product;
import com.tcshop.service.ProductService;
import com.tcshop.controller.data.QueryParams;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation(value = "获取所有product列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(productService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个product", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的product", required = true, dataType = "Product", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Product product){
        if(product != null) {
            if (null == product.getId()) {
                productService.save(product);
            } else {
                productService.update(product);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个product")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的product id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Product product = new Product();
        product.setId(id);
        productService.delete(product);
        return ResultData.ok();
    }
}
