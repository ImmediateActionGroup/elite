package com.gproom.elite.common.cache;

import lombok.Data;

/**
 * @Author xueshan.wei
 * @Date 2018/4/1 下午1:26
 */

@Data
public class CacheParameterProperties {
    private Object [] values;
    private String methodName;
}
