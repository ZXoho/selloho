package com.cn.demo.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class payUtil {

    /**
     * 获取时间戳
     * 时间戳从1970年1月1日00:00:00至今的秒数
     */
    public static long getTimeStamp() {
        Date d = new Date();
        long timeStamp = d.getTime() / 1000;
        return timeStamp;
    }

    /**
     * 获取32位随机串
     */
    public static String getNonceStr() {
        String s = UUID.randomUUID().toString().replace("-","");
        return s;
    }

    /**
     * 获取签名
     */
    public static String getSign() {
       return null;
    }

}
