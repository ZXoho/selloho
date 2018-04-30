package com.cn.demo.Utils;

import java.math.BigDecimal;

public class PriceUtil {



    public static Integer yuanToFee(BigDecimal yuan){
         Integer fee = yuan.multiply(new BigDecimal(100)).intValue();
         return fee;
    }

    public static BigDecimal feeToYuan(Integer fee) {
        return new BigDecimal(Double.valueOf(fee) / 100).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
