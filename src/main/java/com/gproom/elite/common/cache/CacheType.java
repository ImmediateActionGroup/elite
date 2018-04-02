package com.gproom.elite.common.cache;

/**
 * 缓存类型，比如方法缓存，参数缓存
 * - 方法缓存： 以方法名作为缓存的key，不考虑参数，直接缓存整个方法的缓存值，适合缓存固定内容， 这种缓存一般除非手动
 *             刷新，否则缓存一直存在，适合常量属性缓存
 * - 参数缓存： 以方法名加参数值作为缓存key, 适合作为动态参数缓存
 * @Author xueshan.wei
 * @Date 2018/4/1 上午12:39
 */
public enum CacheType {
    /**
     * 默认
     * 自动根据方法是否有参数来决定缓存类型
     * - 无参数：采用 方法缓存
     * - 有参数：采用 方法&参数缓存
     */
    DEFAULT,
    /**
     * 方法缓存
     */
    METHOD,
    /**
     * 方法 & 参数缓存
     */
    METHOD_AND_PARAMETER;
}
