package com.tcshop.controller;

import com.tcshop.entity.Brand;
import com.tcshop.service.BrandService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获取所有brand列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Brand> data = brandService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个brand", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "brand", value = "添加的brand", required = true, dataType = "Brand", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Brand brand){
        brandService.save(brand);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个brand", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的brand的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "brand", value = "更新的brand", required = true, dataType = "Brand", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        brandService.update(id, brand);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个brand")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的brand id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Brand brand = new Brand();
        brand.setId(id);
        brandService.delete(brand);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个brand")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "brand id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Brand brand = new Brand();
        brand.setId(id);
        ok.setData(brandService.get(brand));
        return ok;
    }
}
