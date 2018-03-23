package com.gproom.elite.config;

import com.gproom.elite.interceptor.MethodInterceptor;
import com.gproom.elite.interceptor.ParameterValidInterceptor;
import com.gproom.elite.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午10:30
 */
@Configuration
public class GolbalInterceptorConfig {

    @Autowired
    private PermissionInterceptor permissionInterceptor;
    @Autowired
    private ParameterValidInterceptor parameterValidInterceptor;
    @Bean
    public GlobalInterceptor globalInterceptor(){
        List<MethodInterceptor> interceptors = new ArrayList<>();

        interceptors.add(permissionInterceptor);
        interceptors.add(parameterValidInterceptor);
        return new GlobalInterceptor(interceptors);
    }
}
