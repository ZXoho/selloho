package com.cn.demo.form;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductForm {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    private String productDescription;

    //小图地址
    private String productIcon;

    //商品所属种类
    private  Integer categoryType;


}
