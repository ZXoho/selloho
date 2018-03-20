package com.cn.demo.service.impl;

import com.cn.demo.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productInfoService.findOne("500");
        Assert.assertEquals(500,productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> result = productInfoService.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo2 = productInfoService.findOne("500");
        productInfo2.setProductId("400");
        productInfoService.save(productInfo2);
        Assert.assertEquals("400",productInfo2.getProductId());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> result = productInfoService.findAll(request);
    }
}