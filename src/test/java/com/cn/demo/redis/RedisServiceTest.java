package com.cn.demo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Project: demo
 * Created by admin on 2018/11/26 11:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisServiceTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void set() {
        redisService.set("test", 123456);
    }

    @Test
    public void get() {
        String result = redisService.get("test1");
        System.out.println(result);
    }

    @Test
    public void delete() {
        redisService.delete("test1");
    }

    @Test
    public void bean2String() {
    }

    @Test
    public void string2Bean() {
    }
}