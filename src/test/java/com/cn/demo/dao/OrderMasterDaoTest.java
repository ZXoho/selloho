package com.cn.demo.dao;

import com.cn.demo.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;
    private final String OPENID = "10086";

    @Test
    public void findByBuyerOpenId() {
        PageRequest request = new PageRequest(0, 1);
        Page<OrderMaster> result = orderMasterDao.findBybuyerOpenId(OPENID, request);
        System.out.println(result.getTotalPages());


    }

    @Test
    public void findAllTest() {
        List<OrderMaster> resultList = orderMasterDao.findAll();
        Assert.assertNotEquals(0, resultList.size());
    }

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderName("冒菜");
        orderMaster.setOrderId("8799");
        orderMaster.setBuyerPhone("1828000");
        orderMaster.setBuyerName("男神");
        orderMaster.setBuyerAddress("四川大学临江苑12栋");
        orderMaster.setBuyerOpenId("45646");
        orderMaster.setOrderAmount(new BigDecimal(10.6));
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void deleteTest()  {


    }
}