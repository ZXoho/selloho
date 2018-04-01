package com.cn.demo.dataobject;

import com.cn.demo.enums.OrderStatusEnum;
import com.cn.demo.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 */
@Entity
@Data
public class OrderMaster {

    /** 订单ID */
    @Id
    private String orderId;

    /** 买家姓名 */
    private String buyerName;

    /** 订单电话 */
    private String buyerPhone;

    /** 订单地址 */
    private  String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenId;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单支付状态，默认0为新下单 */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认0为未支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;


}
