package com.tcshop.controller;

import com.tcshop.entity.CustormAccount;
import com.tcshop.service.CustormAccountService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/custormAccount")
public class CustormAccountController {
    @Autowired
    private CustormAccountService custormAccountService;

    @ApiOperation(value = "获取所有custormAccount列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize) {
        ResultData ok = ResultData.ok();
        Page<CustormAccount> data = custormAccountService.selectPage(page, pageSize);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个custormAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "custormAccount", value = "添加的custormAccount", required = true, dataType = "CustormAccount", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody CustormAccount custormAccount){
        custormAccountService.save(custormAccount);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "更新一个custormAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的custormAccount的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "custormAccount", value = "更新的custormAccount", required = true, dataType = "CustormAccount", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody CustormAccount custormAccount) {
        custormAccountService.update(id, custormAccount);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个custormAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的custormAccount id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        CustormAccount custormAccount = new CustormAccount();
        custormAccount.setId(id);
        custormAccountService.delete(custormAccount);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个custormAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "custormAccount id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        CustormAccount custormAccount = new CustormAccount();
        custormAccount.setId(id);
        ok.setData(custormAccountService.get(custormAccount));
        return ok;
    }
}
