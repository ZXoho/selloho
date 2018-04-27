package com.cn.demo.service.impl;

import com.cn.demo.Utils.IpUtil;
import com.cn.demo.Utils.PriceUtil;
import com.cn.demo.Utils.ResultVOUtil;
import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.PayTypeEnum;
import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
/**
 * 组装生成支付所需参数对象
 * @Param request 统一下单请求参数
 */
public class PayServiceImpl implements PayService {

    @Autowired
    private WxPayService wxPayService;
    @Override
    public WxPayUnifiedOrderRequest create(OrderDTO orderDTO, HttpServletRequest request) {
        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setBody("微信支付");
            orderRequest.setOpenid(orderDTO.getBuyerOpenId());
            //元转成分
            orderRequest.setTotalFee(PriceUtil.yuanToFee(orderDTO.getOrderAmount()));
            //outTradeNo  订单号
            orderRequest.setOutTradeNo(orderDTO.getOrderId());
            //tradeType 支付方式
            orderRequest.setTradeType(PayTypeEnum.WX_PAY.getMsg());
            //金额元转换成分
            orderRequest.setSpbillCreateIp(IpUtil.getIP(request));
            return wxPayService.createOrder(orderRequest);
        } catch (Exception e) {
            log.error("【微信支付】支付失败 订单号={} 原因={}", orderDTO.getOrderId(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    }

