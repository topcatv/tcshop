package com.tcshop.controller;

import com.tcshop.entity.Brand;
import com.tcshop.service.BrandService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(brandService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个brand", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的brand", required = true, dataType = "Brand", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Brand brand){
        if(brand != null) {
            if (null == brand.getId()) {
                brandService.save(brand);
            } else {
                brandService.update(brand);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个brand")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的brand id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        Brand brand = new Brand();
        brand.setId(id);
        brandService.delete(brand);
        return ResultData.ok();
    }
}
