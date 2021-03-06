package com.cn.demo.enums;

import lombok.Getter;

@Getter
public enum ResultEnum implements CodeEnum{

    PARAM_ERROR(1, "参数不正确"),

    CART_EMPTY(2, "购物车为空"),

    PRODUCT_DOES_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品数量错误"),

    ORDER_DOES_NOT_EXIST(12, "订单不存在"),

    ORDERDETAIL_DOES_NOT_EXIST(13, "详情表不存在"),

    ORDER_STATUS_ERROR(14, "订单状态不正确"),

    ORDER_UPDATE_FAIL(15, "订单更新失败"),

    ORDER_DETAIL_EMPTY(16, "订单详情为空"),

    ORDER_PAY_STATUS_ERROR(17, "订单支付状况错误"),

    ORDER_FIND_ERROR(18, "订单查询错误"),

    FAIL_TO_GET_IP(19, "获取IP失败"),

    WXPAY_NOTIFY_MONEY_ERROR(20, "微信支付金额不一致"),

    ORDER_CANCEL_SUCCESS(21, "订单取消成功"),

    ORDER_FINISH_SUCCESS(22, "订单完结成功"),

    FAIl(23, "操作失败");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
