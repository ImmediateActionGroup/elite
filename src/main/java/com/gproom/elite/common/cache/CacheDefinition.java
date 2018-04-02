package com.gproom.elite.common.cache;

import com.gproom.elite.annotation.Cache;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * 用于保存 @Cache 的注解内容
 * @Author xueshan.wei
 * @Date 2018/4/1 上午12:05
 */
@Data
public class CacheDefinition {
    /**
     * 原始注解内容
     */
    private Cache annotation;
    /**
     * 描述内容
     */
    private String description;
    /**
     * 是否缓存
     */
    private boolean cache;

    private CacheStrategy strategy;

    private CacheType cacheType;

    /**
     * 是否已经缓存过
     */
    private boolean isCached;


    private String cacheKey;

    private Class [] methodParameterTypes;

    private Object [] methodParameterValues;

    private Method method;


    public boolean isNoParameters(){
        return this.method.getParameterCount() == 0;
    }

}
