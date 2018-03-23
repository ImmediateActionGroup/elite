package com.gproom.elite.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weixueshan
 * @data 2018/1/25 14:41
 * @desc
 */
public class ValidateResult {
    private boolean validate = false;
    private Map<String, String > resultMap = new HashMap<>();

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public Map<String, String> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, String> resultMap) {
        this.resultMap = resultMap;
    }

    public void putResult(String propertyName, String result){
        resultMap.put(propertyName, result);
    }
}
