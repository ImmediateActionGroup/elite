package com.gproom.elite.config;

import com.gproom.elite.common.cache.RedisCacheFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author weixueshan
 * @data 2018/4/2 16:42
 * @desc
 */
@Configuration
public class CacheConfig {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Bean
    public RedisCacheFactory redisCacheFactory(){
        RedisCacheFactory redisCacheFactory = new RedisCacheFactory();
        redisCacheFactory.setTemplate(redisTemplate);

        return redisCacheFactory;
    }

}
