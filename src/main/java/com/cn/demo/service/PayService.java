package com.cn.demo.service;

import com.cn.demo.VO.ResultVO;
import com.cn.demo.dto.OrderDTO;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;

import javax.servlet.http.HttpServletRequest;

public interface PayService {

    WxPayUnifiedOrderRequest create(OrderDTO orderDTO, HttpServletRequest request);
}
