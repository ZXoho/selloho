package com.cn.demo.dao;

import com.cn.demo.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
