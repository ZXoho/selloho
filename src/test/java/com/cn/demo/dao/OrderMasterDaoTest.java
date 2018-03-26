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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    OrderMasterDao orderMasterDao;
    private final String OPENID = "10086";

    @Test
    public void findByBuyerOpenId() throws Exception {
        PageRequest request = new PageRequest(0, 1);
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenId(OPENID, request);
        System.out.println(result.getTotalPages());


    }

    @Test
    public void findAllTest() throws Exception {
        List<OrderMaster> resultList = orderMasterDao.findAll();
        Assert.assertNotEquals(0, resultList.size());
    }

    @Test
    public void saveTest() throws Exception {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderName("冒菜");
        orderMaster.setOrderId("8799");
        orderMaster.setOrderPhone("18280003725");
        orderMaster.setOrderAddress("西华大学临江苑12栋");
        orderMaster.setOpeId("45646");
        OrderMaster result = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);

    }

    @Test
    public void deleteTest() throws Exception {


    }
}