package com.cn.demo.controller;

import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import com.cn.demo.service.OrderService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private WxPayService wxPayService;

    /**
     * 发起与支付
     * 调用统一下单接口，获取“预支付交易会话标识”
     */
    @PostMapping("/unifiedOrder")
    public WxPayUnifiedOrderResult unifiedOrder(@RequestBody WxPayUnifiedOrderRequest orderRequest) throws WxPayException {
        return wxPayService.unifiedOrder(orderRequest);
    }
}
