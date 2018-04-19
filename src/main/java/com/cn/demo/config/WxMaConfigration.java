package com.cn.demo.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import com.github.binarywang.wxpay.config.WxPayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@ConditionalOnClass(WxMaService.class)
@EnableConfigurationProperties(WxMaproperties.class)
public class WxMaConfigration {
    @Autowired
    private WxMaproperties properties;

    @Bean
    @ConditionalOnMissingBean
    public WxMaService wxMaService(WxMaConfig wxMaConfig) {
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig);
        return service;
    }

    @Bean
    @ConditionalOnMissingBean
    public WxPayConfig payConfig() {
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(this.properties.getAppId());
        payConfig.setMchId(this.properties.getMchId());
        payConfig.setMchKey(this.properties.getMchKey());
        payConfig.setKeyPath(this.properties.getKeyPath());
        payConfig.setSubAppId(org.apache.commons.lang3.StringUtils.trimToNull(this.properties.getSubAppId()));
        payConfig.setSubMchId(org.apache.commons.lang3.StringUtils.trimToNull(this.properties.getSubMchId()));
        return payConfig;
    }

}
