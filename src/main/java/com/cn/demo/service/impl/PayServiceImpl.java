package com.cn.demo.service.impl;

import com.cn.demo.Utils.IpUtil;
import com.cn.demo.Utils.JsonUtil;
import com.cn.demo.Utils.MathUtil;
import com.cn.demo.Utils.PriceUtil;
import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.PayTypeEnum;
import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import com.cn.demo.service.OrderService;
import com.cn.demo.service.PayService;
import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyResult;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderRequest;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.generic.MULTIANEWARRAY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Service
@Slf4j
/**
 * 组装生成支付所需参数对象
 * @Param request 统一下单请求参数
 */
public class PayServiceImpl implements PayService {

    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private OrderService orderService;
    @Override
    public WxPayUnifiedOrderRequest create(OrderDTO orderDTO, HttpServletRequest request) {
        try {
            WxPayUnifiedOrderRequest orderRequest = new WxPayUnifiedOrderRequest();
            orderRequest.setBody("微信支付");
            orderRequest.setOpenid(orderDTO.getBuyerOpenId());
            //元转成分
            orderRequest.setTotalFee(PriceUtil.yuanToFee(orderDTO.getOrderAmount()));
            //outTradeNo  订单号
            orderRequest.setOutTradeNo(orderDTO.getOrderId());
            //tradeType 支付方式
            orderRequest.setTradeType(PayTypeEnum.WX_PAY.getMsg());
            //金额元转换成分
            orderRequest.setSpbillCreateIp(IpUtil.getIP(request));
            return wxPayService.createOrder(orderRequest);
        } catch (Exception e) {
            log.error("【微信支付】支付失败 订单号={} 原因={}", orderDTO.getOrderId(), e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public WxPayOrderNotifyResult notify(String notifyData) throws WxPayException {
        //1.验证签名
        //2.验证支付状态
        //3.验证支付金额
        //4.验证支付人（下单人 == 支付人）
        WxPayOrderNotifyResult notifyResult = wxPayService.parseOrderNotifyResult(notifyData);
        log.info("【微信异步通知】，notifyResult={}", JsonUtil.toJson(notifyResult));

        //查询订单
        OrderDTO orderDTO = orderService.findOne(notifyResult.getTransactionId());

        //验证订单是否存在
        if(orderDTO == null) {
            log.error("【微信支付】 订单不存在 orderId={}", notifyResult.getTransactionId());
            throw new SellException(ResultEnum.ORDER_DOES_NOT_EXIST);
        }

        //验证金额是否一至(注意两个比较值的精确度 0.1  0.10）
        BigDecimal feetoYuan = PriceUtil.feeToYuan(notifyResult.getSettlementTotalFee());
        if(!MathUtil.equals(orderDTO.getOrderAmount().doubleValue(), feetoYuan.doubleValue())) {
            log.error("【微信支付】 订单金额不一致 orderId={}, 微信通知金额={}, 订单金额={}",
                      notifyResult.getTransactionId(),
                      notifyResult.getSettlementTotalFee()*100,
                      orderDTO.getOrderAmount());
            throw new SellException(ResultEnum.WXPAY_NOTIFY_MONEY_ERROR);
        }

        //修改订单支付状态
        orderService.paid(orderDTO);
        return notifyResult;
    }
}

