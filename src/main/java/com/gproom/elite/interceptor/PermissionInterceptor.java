package com.gproom.elite.interceptor;

import com.gproom.elite.annotation.PermissionCheck;
import com.gproom.elite.utils.MethodAnnotationUtils;
import com.gproom.elite.utils.PermissionChecker;
import com.gproom.elite.utils.GlobalMethodInvokeContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author xueshan.wei
 * @Date 2018/3/23 下午9:19
 */
@Component
public class PermissionInterceptor implements MethodInterceptor{
    @Autowired
    private PermissionChecker permissionChecker;
    @Override
    public void doBefore(Object... args) {
        Method currentInvokedMethod = GlobalMethodInvokeContextHolder.currentInterceptorMethod();
        if(MethodAnnotationUtils.isMethodContainAnnotation(currentInvokedMethod, PermissionCheck.class)){
            permissionChecker.checkUserPermission();
        }
    }
}
