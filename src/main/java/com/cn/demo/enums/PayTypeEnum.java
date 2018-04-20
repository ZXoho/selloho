package com.cn.demo.enums;

import lombok.Getter;

@Getter
public enum PayTypeEnum {

    WX_PAY(1, "微信支付"),
    ZFB_PAY(2, "支付宝支付"),
    CARD_PAY(3, "银行卡支付"),
    CRASH_PAY(4, "现金支付"),
    ;

    private Integer code;
    private String msg;

    PayTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
