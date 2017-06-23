package com.tcshop.controller;

import com.tcshop.entity.Custormer;
import com.tcshop.service.CustormerService;
import com.github.pagehelper.Page;
import com.tcshop.controller.data.ResultData;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;


@RestController
@RequestMapping("/custormer")
public class CustormerController {
    @Autowired
    private CustormerService custormerService;

    @ApiOperation(value = "获取所有custormer列表", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页号", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "页大小", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultData query(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int pageSize,
                            @RequestParam(defaultValue = "") String keywords) {
        ResultData ok = ResultData.ok();
        Condition condition = new Condition(Custormer.class);
        if (!StringUtils.isEmpty(keywords))
            condition.createCriteria().andCondition(String.format("USER_NAME LIKE '%s'", keywords));
        Page<Custormer> data = custormerService.selectPageByExample(page, pageSize,condition);
        ok.setData(data);
        ok.setTotal(data.getTotal());
        return ok;
    }
    
    @ApiOperation(value = "添加一个custormer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "custormer", value = "添加的custormer", required = true, dataType = "Custormer", paramType="body")
    })
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData save(@RequestBody Custormer custormer){
        String salt = generateSalt();
        String hashedPasswordBase64 = new Sha256Hash(custormer.getPassword(), salt, 1024).toBase64();
        custormer.setPassword(hashedPasswordBase64);
        custormerService.save(custormer);
        return ResultData.ok();
    }

    private String generateSalt(){
        SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
        String hex = secureRandom.nextBytes().toHex();
        return hex;
    }
    
    @ApiOperation(value = "更新一个custormer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "更新的custormer的id", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "custormer", value = "更新的custormer", required = true, dataType = "Custormer", paramType = "body")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResultData update(@PathVariable("id") Integer id, @RequestBody Custormer custormer) {
        custormerService.update(id, custormer);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "删除一个custormer")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除的custormer id", required = true, dataType = "Integer", paramType="path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultData remove(@PathVariable("id") Integer id){
        Custormer custormer = new Custormer();
        custormer.setId(id);
        custormerService.delete(custormer);
        return ResultData.ok();
    }
    
    @ApiOperation(value = "获取一个custormer")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "custormer id", required = true, dataType = "Integer", paramType = "path")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResultData fetch(@PathVariable("id") Integer id) {
        ResultData ok = ResultData.ok();

        Custormer custormer = new Custormer();
        custormer.setId(id);
        ok.setData(custormerService.get(custormer));
        return ok;
    }
}
