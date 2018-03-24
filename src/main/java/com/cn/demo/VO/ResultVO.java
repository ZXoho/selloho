package com.cn.demo.VO;
/**
 * http返回的最外层对象
 */

import lombok.Data;

@Data
public class ResultVO<T> {

    //错误码
    private Integer code;

    //提示信息
    private String msg;

    //具体内容
    private T data;


}
