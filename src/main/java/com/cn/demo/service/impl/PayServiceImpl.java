package com.cn.demo.service.impl;

import com.cn.demo.Utils.ResultVOUtil;
import com.cn.demo.VO.ResultVO;
import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.PayTypeEnum;
import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private WxPayServiceImpl wxPayService;
    @Override
    public ResultVO create(OrderDTO orderDTO) {
        try {

            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setOpenid(orderDTO.getBuyerOpenId());
            //元转成分
            //orderRequest.setTotalFee(WxPayBaseRequest.yuanToFee(order.getTotalFee()));
            //outTradeNo  订单号
            orderRequest.setOutTradeNo(orderDTO.getOrderId());
            //tradeType 支付方式
            orderRequest.setTradeType(PayTypeEnum.WX_PAY.getMsg());
            orderRequest.setTimeStart(orderDTO.getCreateTime().toString());
            return ResultVOUtil.success(wxPayService.createOrder(orderRequest));

        } catch (Exception e) {
            log.error("【微信支付】支付失败 订单号={} 原因={}", orderDTO.getOrderId(), e.getMessage());
            e.printStackTrace();
            return ResultVOUtil.error(0, "微信支付失败");
        }


    }
}
