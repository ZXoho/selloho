package com.cn.demo.service.impl;

import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

    @Override
    public void create(String openId) {
        WxPayServiceImpl wxPayService = new WxPayServiceImpl();


    }
}
