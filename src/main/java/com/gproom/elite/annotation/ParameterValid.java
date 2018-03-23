package com.gproom.elite.annotation;

import java.lang.annotation.*;

/**
 * 参数验证注解
 * 验证加了此注解的方法的参数, 注意该参数类型暂时必须为 自定义类 类型
 * 后期会加入对不同属性的验证
 * @Author xueshan.wei
 * @Date 2018/3/23 下午9:12
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParameterValid {
}
