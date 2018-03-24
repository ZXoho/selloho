package com.cn.demo.service.impl;

import com.cn.demo.dao.ProductInfoDao;
import com.cn.demo.dataobject.ProductInfo;
import com.cn.demo.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }



    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(0) ;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }


    @Override
    public Page<ProductInfo> findAll(org.springframework.data.domain.Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }
}
