package com.cn.demo.dataobject;

import com.cn.demo.Utils.EnumUtil;
import com.cn.demo.enums.ProductStatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

   @javax.persistence.Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    private String productDescription;

    //小图地址
    private String productIcon;

    //商品状态,0为商家，1为上架
    private Integer productStatus = ProductStatusEnum.SALE.getCode();

    //商品所属种类
    private  Integer categoryType;

    private Date createTime;

    private  Date updateTime;

 @JsonIgnore
 public ProductStatusEnum getProductStatusEnum() {
  return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
 }





}
