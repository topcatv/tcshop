package com.tcshop.controller;

import com.tcshop.entity.CustormAccount;
import com.tcshop.service.CustormAccountService;
import com.tcshop.controller.data.QueryParams;
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
            @ApiImplicitParam(name = "query", value = "查询对象", required = true, dataType = "QueryParams", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData query(@RequestBody QueryParams query) {
        ResultData ok = ResultData.ok();
        ok.setData(custormAccountService.selectPage(query.getPage(), query.getPageSize()));
        return ok;
    }

    @ApiOperation(value = "添加或更新一个custormAccount", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "添加或更新的custormAccount", required = true, dataType = "CustormAccount", paramType="body")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody CustormAccount custormAccount){
        if(custormAccount != null) {
            if (null == custormAccount.getId()) {
                custormAccountService.save(custormAccount);
            } else {
                custormAccountService.update(custormAccount);
            }
        }
            return ResultData.ok();
        }

    @ApiOperation(value = "删除一个custormAccount")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的custormAccount id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData remove(@PathVariable("id") Integer id){
        CustormAccount custormAccount = new CustormAccount();
        custormAccount.setId(id);
        custormAccountService.delete(custormAccount);
        return ResultData.ok();
    }
}
