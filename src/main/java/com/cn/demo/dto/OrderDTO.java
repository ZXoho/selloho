package com.cn.demo.dto;
import com.cn.demo.Utils.EnumUtil;
import com.cn.demo.dataobject.OrderDetail;
import com.cn.demo.enums.OrderStatusEnum;
import com.cn.demo.enums.PayStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 订单名称
     */
    private String BuyerName;

    /**
     * 订单电话
     */
    private String BuyerPhone;

    /**
     * 订单地址
     */
    private String BuyerAddress;

    /**
     * 买家微信openid
     */
    private String BuyerOpenId;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单支付状态，默认0为新下单
     */
    private Integer orderStatus = 0;

    /**
     * 支付状态，默认0为未支付
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    //@JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间
     */
    //@JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
