package com.cn.demo.service;

import com.cn.demo.VO.ResultVO;
import com.cn.demo.dto.OrderDTO;

public interface PayService {

    ResultVO create(OrderDTO orderDTO);
}
