package com.cn.demo.service.impl;

import com.cn.demo.dao.SellerInfoDao;
import com.cn.demo.dataobject.SellerInfo;
import com.cn.demo.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class SellerServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo selectSellerByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

}
