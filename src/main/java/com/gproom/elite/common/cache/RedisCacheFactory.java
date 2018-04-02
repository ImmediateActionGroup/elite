package com.gproom.elite.common.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;

/**
 * @author weixueshan
 * @data 2018/4/2 16:30
 * @desc
 */
@Slf4j
public class RedisCacheFactory<K, V> extends AbstractCacheFactory<K, V>{
    private RedisTemplate<K, V> template;
    private ValueOperations<K, V> operations;

    public void setTemplate(RedisTemplate<K, V> template) {
        Assert.notNull(template, "redis template could't be null");
        this.template = template;
        this.operations = template.opsForValue();
    }


    @Override
    protected void setCache(K cacheKey, V cacheValue) {
        log.info("设置redis 缓存");
        if(cacheKey == null){
            return;
        }
        operations.set(cacheKey, cacheValue);
    }

    @Override
    protected V getCache(K cacheKey) {
        log.info("获取redis 缓存");

        return operations.get(cacheKey);
    }
}
