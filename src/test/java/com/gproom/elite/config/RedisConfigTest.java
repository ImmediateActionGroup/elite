package com.gproom.elite.config;

import com.gproom.elite.EliteApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author weixueshan
 * @data 2018/4/2 15:00
 * @desc
 */
public class RedisConfigTest extends EliteApplicationTests{
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() throws Exception{
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("hello", "hello redis");

        System.out.println(valueOperations.get("hello"));
    }
}
