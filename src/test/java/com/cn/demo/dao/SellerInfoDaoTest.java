package com.cn.demo.dao;

import com.cn.demo.dataobject.SellerInfo;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {

    @Autowired
    private SellerInfoDao sellerInfoDao;


    @Test
    public void save() {
        SellerInfo seller = new SellerInfo();
        seller.setOpenid("afggs984655");
        seller.setSellerId("f354s54f5d");
        seller.setPassword("7st8fs5v");
        seller.setSellerName("周垚旭");
        SellerInfo result = sellerInfoDao.save(seller);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo seller = sellerInfoDao.findByOpenid("afggs984655");
        System.out.println(seller);
        Assert.assertNotNull(seller);
    }
}