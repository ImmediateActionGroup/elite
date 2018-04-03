package com.gproom.elite.config;

import com.gproom.elite.common.cache.AbstractCacheFactory;
import com.gproom.elite.common.cache.AbstractCacheManager;
import com.gproom.elite.common.cache.RedisCacheFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author xueshan.wei
 * @Date 2018/3/31 下午11:57
 */
@Component
@Slf4j
public class CacheManager extends AbstractCacheManager {
    @Autowired
    private RedisCacheFactory<Object> redisCacheFactory;
    @Override
    protected void doCacheBefore() {
//        this.setCacheFactory(redisCacheFactory);
    }

    @Override
    protected void doCacheAfter() {

    }

    @Override
    public AbstractCacheFactory getCacheFactory() {
        return super.getCacheFactory();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("初始化缓存Factory");
        this.setCacheFactory(redisCacheFactory);
    }
}
