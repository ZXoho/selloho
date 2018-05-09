package com.cn.demo.service.impl;

import com.cn.demo.dao.SellerInfoDao;
import com.cn.demo.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceImplTest {

    private static final String openid = "afggs984655";
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Test
    public void selectSellerByOpenid() throws Exception {
        SellerInfo seller = sellerInfoDao.findByOpenid(openid);
        System.out.println(seller);
        Assert.assertNotNull(seller);
    }
}