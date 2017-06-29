package com.tcshop.controller;

import com.tcshop.controller.data.ResultData;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by topcat on 2017/6/29.
 */
@RestController
@RequestMapping("/api/wechat")
public class WechatController {

    @Autowired
    private WxMpService wxService;

    @GetMapping("/getOpenId")
    public ResultData getOpenId(String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(code);
        String lang = "zh_CN";
        WxMpUser wxMpUser = wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, lang);
        ResultData ok = ResultData.ok();
        ok.setData(wxMpUser);
        return ok;
    }
}
