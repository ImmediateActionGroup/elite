package com.gproom.elite.interceptor;


/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午9:16
 */
public interface MethodInterceptor {

    default void doBefore(Object ... args){
        //do something
    }

    default void doAfter(Object ... args){
        // do something
    }
}
