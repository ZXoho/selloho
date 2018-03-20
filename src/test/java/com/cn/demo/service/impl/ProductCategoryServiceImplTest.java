package com.cn.demo.service.impl;

import com.cn.demo.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private  ProductCategoryServiceImpl productCategoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory =  productCategoryService.findOne(10);
        System.out.println(productCategory);

    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> list = productCategoryService.findAll();
        System.out.println(list);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> result = productCategoryService.findByCategoryTypeIn(list);
        System.out.println(result);
    }

    @Test
    @Transactional
    public void save() throws Exception {

    }
}