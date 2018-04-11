package com.cn.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.Entity;

@ConfigurationProperties(prefix = "wechat.miniapp")
@Entity
public class WxMaproperties {


    /**
     * 设置微信小程序的appid
     */
    private String appid;

    /**
     * 设置微信小程序的Secret
     */
    private String secret;

    /**
     * 设置微信小程序的token
     */
    private String token;

    /**
     * 设置微信小程序的EncodingAESKey
     */
    private String aesKey;

    /**
     * 消息格式，XML或者JSON
     */
    private String msgDataFormat;


}
