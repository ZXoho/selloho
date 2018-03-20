package com.cn.demo.dao;

import com.cn.demo.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    ProductInfoDao productInfoDao;

    @Test
    @org.springframework.transaction.annotation.Transactional
    public void saveTset() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("大刀肉");
        productInfo.setCategoryType(3);
        productInfo.setProductDescription("香辣好吃");
        productInfo.setProductPrice(new BigDecimal(0.25));
        productInfo.setProductStock(500);
        productInfo.setProductStatus(0);
        productInfo.setProductId("500");
        productInfo.setProductIcon("https://xxxxx.pjf");
        ProductInfo result = productInfoDao.save(productInfo);
        //System.out.println(result);
        org.junit.Assert.assertNotNull(result);
    }


    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfos = productInfoDao.findByProductStatus(0);
        System.out.println(productInfos);
    }
}