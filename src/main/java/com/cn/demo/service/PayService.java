package com.cn.demo.service;

import com.cn.demo.VO.ResultVO;
import com.cn.demo.dto.OrderDTO;

import javax.servlet.http.HttpServletRequest;

public interface PayService {

    ResultVO create(OrderDTO orderDTO, HttpServletRequest request);
}
