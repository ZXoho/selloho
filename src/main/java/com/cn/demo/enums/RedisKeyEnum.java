package com.cn.demo.enums;

import lombok.Getter;

/**
 * Project: demo
 * Created by admin on 2018/11/25 20:29
 */
@Getter
public enum RedisKeyEnum  {

    SELLER_PRODUCT_LIST("seller/product/list"),
    ;

    private String msg;

    RedisKeyEnum(String msg) {
        this.msg = msg;
    }





}
