package com.cn.demo.dataobject;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
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
    private Integer productStatus;

    //商品所属种类
    private  Integer categoryType;

}
