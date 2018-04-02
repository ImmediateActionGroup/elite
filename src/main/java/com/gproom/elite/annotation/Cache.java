package com.gproom.elite.annotation;

import com.gproom.elite.common.cache.CacheStrategy;
import com.gproom.elite.common.cache.CacheType;

import java.lang.annotation.*;

/**
 * 接口缓存注解，添加到方法上
 *
 * @Author xueshan.wei
 * @Date 2018/3/31 下午11:52
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    /**
     * 是否注解生效, 默认为true（生效）
     * @return
     */
    boolean value() default true;

    /**
     * 缓存描述
     * @return
     */
    String description () default "";

    /**
     * 缓存策略，默认为 CacheStrategy.DEFAULT
     * @return
     */
    CacheStrategy strategy() default CacheStrategy.DEFAULT;

    /**
     * 缓存类型，默认为根据参数类型自动选择缓存方式
     * @return
     */
    CacheType cacheType() default CacheType.DEFAULT;
}
