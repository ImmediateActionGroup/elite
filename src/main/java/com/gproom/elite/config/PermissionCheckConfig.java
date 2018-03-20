package com.gproom.elite.config;

import com.gproom.elite.service.UserPermissionService;
import com.gproom.elite.utils.PermissionChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author weixueshan
 * @data 2018/3/20 19:55
 * @desc
 */
@Configuration
public class PermissionCheckConfig {

    @Bean
    public PermissionChecker permissionCheck(UserPermissionService userPermissionService){
        return new PermissionChecker(userPermissionService);
    }
}
