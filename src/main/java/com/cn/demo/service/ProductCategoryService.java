package com.cn.demo.service;

import com.cn.demo.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    //卖家端查询所有
    List<ProductCategory> findAll();

    //买家端查询
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //新增，更新(卖家）
    ProductCategory save(ProductCategory productCategory);

    //删除(卖家)





}
