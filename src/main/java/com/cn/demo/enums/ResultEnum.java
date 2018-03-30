package com.cn.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PRODUCT_DOES_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "商品数量错误"),
    ORDER_DOES_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_DOES_NOT_EXIST(13, "详情表不存在"),
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
