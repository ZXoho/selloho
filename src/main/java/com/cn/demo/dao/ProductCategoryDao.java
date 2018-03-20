package com.cn.demo.dao;

import com.cn.demo.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

     List<ProductCategory> findProductCategoryByCategoryTypeIn(List<Integer> categoryTypeList);

}
