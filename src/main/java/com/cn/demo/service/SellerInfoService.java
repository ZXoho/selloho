package com.cn.demo.service;

import com.cn.demo.dataobject.SellerInfo;

public interface SellerInfoService {

    SellerInfo selectSellerByOpenid(String openid);
}
