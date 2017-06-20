package com.tcshop.controller;

import com.tcshop.entity.Category;
import com.tcshop.service.CategoryService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取所有category列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Category> data = categoryService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个category", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "添加的category", required = true, dataType = "Category", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Category category){
        categoryService.save(category);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个category", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的category的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "category", value = "更新的category", required = true, dataType = "Category", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Category category) {
        categoryService.update(id, category);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个category")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的category id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Category category = new Category();
        category.setId(id);
        categoryService.delete(category);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个category")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "category id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Category category = new Category();
        category.setId(id);
        ok.setData(categoryService.get(category));
        return ok;
    }
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public ResultData loadCategoryTree() {
        ResultData ok = ResultData.ok();
        ok.setData(categoryService.loadCategoryTree(null));
        return ok;
    }

}
