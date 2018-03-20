package com.gproom.elite.config;

import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.exception.BusinessException;
import com.gproom.elite.utils.PermissionChecker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weixueshan
 * @data 2018/3/20 19:24
 * @desc
 */
@Aspect
@Component
@Slf4j
public class GlobalInterceptor {

    private final static String PERMISSION_KEY = "pkey";

    @Autowired
    private PermissionChecker permissionChecker;

    @Pointcut("@annotation(com.gproom.elite.annotation.PermissionCheck)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String pkey = request.getHeader(PERMISSION_KEY);
        if(!StringUtils.hasText(pkey) || !permissionChecker.checkPermission(pkey)){
            log.error("权限校验拦截, 权限校验失败, data : {}", request.getContextPath());
            throw new BusinessException(ExceptionEnums.PERMISSION_CHECK_ERROR);
        }else {
            log.info("权限校验拦截, 权限校验成功");
        }
    }


    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint) throws Exception{
        System.out.println("");
    }
}
