package com.cn.demo.service.impl;

import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import com.cn.demo.service.BuyerService;
import com.cn.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            return null;
        }
        else if(!orderDTO.getBuyerOpenId().equalsIgnoreCase(openid)) {
            log.error(" 【查询订单】 订单openid不正确");
            throw new SellException(ResultEnum.ORDER_FIND_ERROR);
        }
        else {
        return orderDTO;
        }
    }

}
