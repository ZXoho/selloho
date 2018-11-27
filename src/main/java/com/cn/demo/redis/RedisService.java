package com.cn.demo.redis;

import com.alibaba.fastjson.JSON;
import com.cn.demo.enums.RedisKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static org.springframework.data.repository.init.ResourceReader.Type.JSON;

/**
 * Project: demo
 * Created by admin on 2018/11/25 20:51
 */

@Service
@Slf4j
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    /**
     * 加入缓存
     * @param prefix
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(String prefix, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = bean2String(value);
            if(str.isEmpty()) {
                return false;
            }else {
                jedis.set(prefix, str);
                return true;
            }
        } finally {
            if(jedis != null)
                jedis.close();
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            if(key.isEmpty() || key.length() <= 0) {
                System.out.println("redisKey is error");
                log.error("redisKey is error");
            }
            jedis = jedisPool.getResource();
            String str = jedis.get(key);
            if(str == null)
                log.error("RedisKey is not valid");
                return str;
        } finally {
            if(jedis != null)
                jedis.close();
        }
    }

    public void delete(String key) {
        Jedis jedis = null;
        try {
            if(key.isEmpty() || key.length() <= 0) {
                System.out.println("key is error");
                log.error("key is error");
            }
            jedis = jedisPool.getResource();
            jedis.del(key);
        } finally {

        }
    }


    /**
     * 转换成String
     * @param value
     * @param <T>
     * @return
     */
    public <T> String bean2String(T value) {
        if(value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class) {
            return "" + value;
        }else if(clazz == long.class) {
            return "" + value;
        }else if(clazz == String.class) {
            return (String)value;
        }else
            return com.alibaba.fastjson.JSON.toJSONString(value);
    }

    /**
     * Sring转成其他类型
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T string2Bean(String value, Class<?> clazz) {
        if(value == null || value.length() <= 0 || clazz == null) {
            return null;
        }else if(clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(value);
        }else if(clazz == long.class) {
            return (T) Long.valueOf(value);
        }else
            return (T) com.alibaba.fastjson.JSON.toJavaObject(com.alibaba.fastjson.JSON.parseObject(value), clazz);
    }


}
