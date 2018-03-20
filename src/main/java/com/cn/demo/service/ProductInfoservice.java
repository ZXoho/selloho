package com.cn.demo.service;

import com.cn.demo.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface ProductInfoservice {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(org.springframework.data.domain.Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //List<ProductInfo> findByCategoryType();

    //查询上架商品
    List<ProductInfo> findUpAll();

    //加库存

    //减库存

}
