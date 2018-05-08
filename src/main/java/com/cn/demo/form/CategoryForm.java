package com.cn.demo.form;

import lombok.Data;

@Data
public class CategoryForm {

    private Integer categoryId;

    /** 种类名称 */
    private String categoryName;

    /** 种类编号 */
    private Integer categoryType;

}
