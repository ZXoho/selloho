package com.cn.demo.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(WxMaService.class)
@EnableConfigurationProperties(WxPayProperties.class)

public class WxPayConfigration {

    @Autowired
    private WxPayProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxPayConfig payConfig() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(this.properties.getAppId());
        payConfig.setMchId(this.properties.getMchId());
        payConfig.setMchKey(this.properties.getMchKey());
        payConfig.setKeyPath(this.properties.getKeyPath());
        payConfig.setNotifyUrl(this.properties.getNotifyUrl());
        payConfig.setSubAppId(org.apache.commons.lang3.StringUtils.trimToNull(this.properties.getSubAppId()));
        payConfig.setSubMchId(org.apache.commons.lang3.StringUtils.trimToNull(this.properties.getSubMchId()));
        return payConfig;
    }

    @Bean
    //@ConditionalOnMissingBean
    public WxPayService wxPayService(WxPayConfig wxPayConfig) {
        WxPayService service = new WxPayServiceImpl();
        service.setConfig(wxPayConfig);
        return service;
    }

}
