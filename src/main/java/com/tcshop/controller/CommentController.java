package com.tcshop.controller;

import com.tcshop.entity.Comment;
import com.tcshop.service.CommentService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "获取所有comment列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<Comment> data = commentService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加或更新一个comment", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "comment", value = "添加的comment", required = true, dataType = "Comment", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Comment comment){
        commentService.save(comment);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个comment", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的comment的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "comment", value = "更新的comment", required = true, dataType = "Comment", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Comment comment) {
        commentService.update(id, comment);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个comment")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的comment id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Comment comment = new Comment();
        comment.setId(id);
        commentService.delete(comment);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个comment")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "comment id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Comment comment = new Comment();
        comment.setId(id);
        ok.setData(commentService.get(comment));
        return ok;
    }
}
