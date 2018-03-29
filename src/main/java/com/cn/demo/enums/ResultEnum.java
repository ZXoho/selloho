package com.cn.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_DOES_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品数量错误"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
