package com.cn.demo.controller;

import com.cn.demo.Utils.payUtil;
import com.cn.demo.dto.OrderDTO;
import com.cn.demo.service.OrderService;
import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.bean.request.WxPayRefundRequest;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.WxPayRefundResult;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    /**
     * 发起与支付
     * 调用统一下单接口，获取“预支付交易会话标识”
     */
    @PostMapping("/unifiedOrder")
    public ModelAndView unifiedOrder(@RequestBody String orderId,
                                     @RequestBody HttpServletRequest request, //TODO 怎样获得request?
                                     Map<String, Object>map) throws WxPayException {
        OrderDTO orderDTO = orderService.findOne(orderId);
        WxPayUnifiedOrderRequest orderRequest = payService.create(orderDTO, request);
        WxPayUnifiedOrderResult orderResult = wxPayService.unifiedOrder(orderRequest);
        map.put("orderRequest", orderRequest);
        map.put("orderResult", orderResult);
        map.put("timeStamp", payUtil.getTimeStamp());
        map.put("nonceStr", payUtil.getNonceStr());

        return new ModelAndView("pay/unifiedOrder", map);
    }

    /**
     * 取消订单
     * @param refundRequest 请求对象
     * @return WxPayRefundResult
     */
    @PostMapping("/cancel")
    public WxPayRefundResult cancel(@RequestBody WxPayRefundRequest refundRequest)throws WxPayException {
        return wxPayService.refund(refundRequest);

    }
}
