package com.gproom.elite.interceptor;

import com.gproom.elite.annotation.ParameterValid;
import com.gproom.elite.common.enums.ExceptionEnums;
import com.gproom.elite.exception.ParameterValidException;
import com.gproom.elite.utils.MethodAnnotationUtils;
import com.gproom.elite.utils.GlobalMethodInvokeContextHolder;
import com.gproom.elite.utils.ValidateResult;
import com.gproom.elite.utils.ValidatorUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 参数验证拦截器
 * @Author xueshan.wei
 * @Date 2018/3/23 下午10:26
 */
@Component
public class ParameterValidInterceptor implements MethodInterceptor{

    @Override
    public void doBefore(Object... args) {
        Method currentInvokedMethod = GlobalMethodInvokeContextHolder.currentInterceptorMethod();
        if(MethodAnnotationUtils.isMethodContainAnnotation(currentInvokedMethod, ParameterValid.class)){
            Object arg = GlobalMethodInvokeContextHolder.getFirstArg();
            ValidateResult validateResult = ValidatorUtils.validate(arg);
            if(!validateResult.isValidate()){
                throw new ParameterValidException(ExceptionEnums.PARAMETER_VALID_ERROR, validateResult.getResultMap());
            }
        }
    }
}
