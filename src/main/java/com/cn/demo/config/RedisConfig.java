package com.cn.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
@Configuration
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {

    private String host;
    private int port;
    private int poolMaxActive;
    private int poolMaxWait;
    private int poolMaxIdle;
    private int poolMinIdle;
    private int timeOut;

    @Bean
    public JedisPool jedisPool(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(poolMaxIdle);
        jedisPoolConfig.setMaxWaitMillis(poolMaxWait * 1000);
        JedisPool jedisPool = new JedisPool(
                jedisPoolConfig, host, port, timeOut
                );
        return jedisPool;

    }
}
