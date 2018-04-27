package com.cn.demo.Utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class payUtilTest {

    @Test
    public void getTimeStamp() {
        Date d = new Date();
        long timeStamp = d.getTime() / 1000;
        System.out.println(timeStamp);
    }

    @Test
    public void getNonceStr() {
        String s = UUID.randomUUID().toString().replace("-","");
        System.out.println(s);
    }

}