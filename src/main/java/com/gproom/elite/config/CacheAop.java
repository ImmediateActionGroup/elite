package com.gproom.elite.config;

import com.gproom.elite.common.cache.AbstractCache;
import com.gproom.elite.common.cache.CacheUtils;
import com.gproom.elite.common.cache.RedisCacheFactory;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author xueshan.wei
 * @Date 2018/3/31 下午11:57
 */
@Component
@Slf4j
public class CacheAop extends AbstractCache{
    @Autowired
    private RedisCacheFactory<String, Object> redisCacheFactory;
    @Override
    protected void doCacheBefore() {
        this.setCacheFactory(redisCacheFactory);
    }

    @Override
    protected void doCacheAfter() {

    }
}
