package com.cn.demo.service.impl;

import com.cn.demo.dao.OrderMasterDao;
import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.PayTypeEnum;
import com.cn.demo.service.OrderService;
import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayServiceImpl payService;

    @Test
    public void create() throws  Exception{
        OrderDTO orderDTO = orderService.findOne("1523102750326979443");
        payService.create(orderDTO);
    }
}