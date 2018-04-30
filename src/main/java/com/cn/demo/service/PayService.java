package com.cn.demo.service;

import com.cn.demo.VO.ResultVO;
import com.cn.demo.dto.OrderDTO;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.exception.WxPayException;

import javax.servlet.http.HttpServletRequest;

public interface PayService {

    /**
     * 创建预处理订单 UnifiedOrderRequest
     */
    WxPayUnifiedOrderRequest create(OrderDTO orderDTO, HttpServletRequest request);

    /**
     * 微信异步通知
     */
    WxPayOrderNotifyResult notify(String notifyData) throws WxPayException;
}

