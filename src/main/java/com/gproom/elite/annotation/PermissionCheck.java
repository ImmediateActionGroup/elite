package com.gproom.elite.annotation;

import java.lang.annotation.*;

/**
 * @author weixueshan
 * @data 2018/3/20 19:27
 * @desc
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionCheck {
    String value() default "";
}
