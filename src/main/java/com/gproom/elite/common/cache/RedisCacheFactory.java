package com.gproom.elite.common.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;

import java.util.Set;

/**
 * @author weixueshan
 * @data 2018/4/2 16:30
 * @desc
 */
@Slf4j
public class RedisCacheFactory<V> extends AbstractCacheFactory<String, V> implements InitializingBean{
    private RedisTemplate<String, V> template;
    private ValueOperations<String, V> operations;
    //是否初始化的时候清空redis 方法缓存,默认为清空
    @Value("${method_cache.init-clear:true}")
    private boolean initClear;

    private static final String REDIS_CACHE_KEY_PREFIX = "redis_method_cache_";

    public void setTemplate(RedisTemplate<String, V> template) {
        Assert.notNull(template, "redis template could't be null");
        this.template = template;
        this.operations = template.opsForValue();
    }


    @Override
    protected void setCache(String cacheKey, V cacheValue) {
        log.info("设置redis 缓存");
        if(cacheKey == null){
            return;
        }
        cacheKey = getCacheKey(cacheKey);

        operations.set(cacheKey, cacheValue);
    }

    @Override
    protected V getCache(String cacheKey) {
        log.info("获取redis 缓存");
        cacheKey = getCacheKey(cacheKey);
        return operations.get(cacheKey);
    }

    private String getCacheKey(String cacheKey){
        return REDIS_CACHE_KEY_PREFIX + cacheKey;
    }

    public int clear(){
        log.info("开始清除redis cache .....");
        int cacheKeysSzie = 0;
        Set<String> cacheKeys = template.keys(REDIS_CACHE_KEY_PREFIX + "*");
        if(cacheKeys != null && cacheKeys.size() > 0){
            template.delete(cacheKeys);
            cacheKeysSzie = cacheKeys.size();
            log.info("清除redis cache完成....., keys-size: {}", cacheKeys.size());
        }else {
            log.info("没有找到要清除的cache key");
        }
        return cacheKeysSzie;
    }

    @Override
    public void clearSpecialKey(String key) {
        String cacheKey = REDIS_CACHE_KEY_PREFIX + key;
        template.delete(cacheKey);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(initClear == true){
            clear();
        }
    }
}
