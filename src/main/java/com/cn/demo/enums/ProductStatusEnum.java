package com.cn.demo.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    SALE(0, "上架"),
    NOT_SALE(1, "下架")
    ;

    private Integer code;
    private String msg;
    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
