package com.cn.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单主表
 */
@Entity
@Data
public class OrderMaster {

    /** 订单ID */
    @Id
    private String orderId;

    private String orderName;

    /** 买家姓名 */
    private String buyerName;

    /** 订单电话 */
    private String orderPhone;

    /** 订单地址 */
    private  String orderAddress;

    /** 买家微信openid */
    private String buyerOpenId;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单支付状态，默认0为新下单 */
    private Integer orderStats = 0;

    /** 支付状态，默认0为未支付 */
    private Integer payStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;


}
