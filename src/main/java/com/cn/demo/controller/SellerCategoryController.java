package com.cn.demo.controller;


import com.cn.demo.Utils.KeyUntil;
import com.cn.demo.dataobject.ProductCategory;
import com.cn.demo.dataobject.ProductInfo;
import com.cn.demo.exception.SellException;
import com.cn.demo.form.CategoryForm;
import com.cn.demo.form.ProductForm;
import com.cn.demo.service.ProductCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("/category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                              Map<String, Object> map) {
        ProductCategory category = new ProductCategory();
        if (categoryId != null) {
            category = categoryService.findOne(categoryId);
            map.put("category", category);
        }
        return new ModelAndView("/category/index", map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if(bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/list");
            return new ModelAndView("/common/error", map);
        }
        ProductCategory category = new ProductCategory();
        try {
            if(!StringUtils.isEmpty(form.getCategoryId())) {
                category = categoryService.findOne(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, category);
            categoryService.save(category);

        } catch (SellException e) {
            map.put("url", "/sell/seller/category/index");
            map.put("msg", e.getMessage());
            return new ModelAndView("/common/error", map);
        }
        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("/common/success", map);
    }
    }


