package com.cn.demo.controller;

import com.cn.demo.Utils.ResultVOUtil;
import com.cn.demo.VO.ResultVO;
import com.cn.demo.converter.OrderForm2OrderDTO;
import com.cn.demo.dto.OrderDTO;
import com.cn.demo.enums.ResultEnum;
import com.cn.demo.exception.SellException;
import com.cn.demo.form.OrderForm;
import com.cn.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    OrderService orderService;

    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        //类型转换
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 订单不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
<<<<<<< HEAD
        if(StringUtils.isEmpty(openid)) {
=======
        if (StringUtils.isEmpty(openId)) {
>>>>>>> cb373c463406ac5b8fc27560bc39d521898f2dfb
            log.error("【查询订单列表】openId不能为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }

    //订单详情
    @GetMapping("/detail")
<<<<<<< HEAD
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderId) {
       //TODO 方法不安全
       OrderDTO orderDTO = orderService.findOne(orderId);
       return ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderid") String orderId) {

        //TODO 方法不安全
=======
    public ResultVO<OrderDTO> detail(@RequestParam("openId") String openId,
                                     @RequestParam("orderId") String orderID) {
        //TODO
        OrderDTO result = orderService.findOne(orderID);
        return ResultVOUtil.success(result);
    }


        //取消订单
        @PostMapping("/cancel")
        public ResultVO cancel (@RequestParam("openId") String openId,
                                @RequestParam("orderId") String orderId){
        //TODO 不安全
>>>>>>> cb373c463406ac5b8fc27560bc39d521898f2dfb
        OrderDTO orderDTO = orderService.findOne(orderId);
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }
}
