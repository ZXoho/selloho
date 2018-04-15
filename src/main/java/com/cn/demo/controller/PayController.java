package com.cn.demo.controller;

import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import com.cn.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId) {

        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            log.error("【创建支付订单】订单不存在");
            throw new SellException(ResultEnum.ORDER_DOES_NOT_EXIST);
        }

        //发起支付


    }
}
