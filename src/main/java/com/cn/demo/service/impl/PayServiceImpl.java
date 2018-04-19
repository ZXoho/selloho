package com.cn.demo.service.impl;

import com.cn.demo.dto.OrderDTO;
import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private WxPayServiceImpl wxPayService;
    @Override
    public void create(OrderDTO orderDTO) {

        WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();

    }
}
