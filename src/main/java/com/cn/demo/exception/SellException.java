package com.cn.demo.exception;

import com.cn.demo.enums.ResultEnum;

public class SellException extends RuntimeException{

   private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
