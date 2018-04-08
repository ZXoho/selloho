package com.cn.demo.service;

import com.cn.demo.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public interface BuyerService {

    //检查用户要查询的信息是是否于用户本人
    OrderDTO checkOrderOwner(String openid, String orderId);



}
