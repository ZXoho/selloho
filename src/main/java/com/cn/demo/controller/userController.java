package com.cn.demo.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.cn.demo.Utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wechat/user")
@Slf4j
public class userController {

    @Autowired
    WxMaService wxMaService;

    /**
     * 登录接口
     * 小程序 wx.request()传值code
     * code 有效期5分钟
     */
    @GetMapping("/login")
    public String login(String code) {
        if (StringUtils.isEmpty(code)) {
            return "code is empty";
        }
        try {
            WxMaJscode2SessionResult sessionResult = wxMaService.getUserService().getSessionInfo(code);
            log.info("openid: openid={}", sessionResult.getOpenid());
            log.info("sessionKey: sessionKey={}", sessionResult.getSessionKey());
            return JsonUtil.toJson(sessionResult);
        } catch (WxErrorException e) {
            log.error(e.getMessage());
            return e.toString();
        }

    }

}
