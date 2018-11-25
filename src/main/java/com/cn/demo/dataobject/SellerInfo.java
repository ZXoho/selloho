package com.cn.demo.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;
    private String sellerName;
    private String openid;
    private String password;
    private Date createTime;
    private Date updateTime;
    private String roleName;
}
