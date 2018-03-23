package com.gproom.elite.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 参数校验工具类
 *
 * @author weixueshan
 * @data 2018/1/25 11:36
 * @desc
 */
@Slf4j
public class ValidatorUtils {
    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * 校验参数 只返回校验是否通过
     * @param object 待校验的对象
     * @param <T>
     * @return true | false
     */
    public static <T> boolean validateResult(T object){
        ValidateResult result = validate(object);
        return result.isValidate();
    }

    public static <T> ValidateResult validate(T object) {
        ValidateResult validateResult = new ValidateResult();
        if (ObjectUtils.isEmpty(object)) {
            log.error("校验参数失败，参数对象为null!");
            validateResult.setValidate(false);
            return validateResult;
        }
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);
        if (constraintViolations.size() > 0) {
            validateResult.setValidate(false);
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validateResult.putResult(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
            }
        } else {
            validateResult.setValidate(true);
        }
        return validateResult;
    }

}
