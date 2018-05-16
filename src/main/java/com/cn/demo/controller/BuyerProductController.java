package com.cn.demo.controller;

import com.cn.demo.Utils.ResultVOUtil;
import com.cn.demo.VO.ProductInfoVO;
import com.cn.demo.VO.ProductVO;
import com.cn.demo.VO.ResultVO;
import com.cn.demo.dataobject.ProductCategory;
import com.cn.demo.service.ProductCategoryService;
import com.cn.demo.dataobject.ProductInfo;
import com.cn.demo.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "#sellerId", condition = "#sellerId.length() < 3", unless = "#result.getCode() != 0")
    public ResultVO list(@RequestParam("sellerId")String sellerId) {
        //查询所有上架商品
        List<ProductInfo> productInfoList = productInfoList = productInfoService.findUpAll();

        //查询所有种类
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //数据整理
        List<ProductVO> productVOList = new ArrayList<>();
        List<ProductInfoVO> productInfoVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);


    }
}
