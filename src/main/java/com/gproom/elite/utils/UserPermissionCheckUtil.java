package com.gproom.elite.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午11:23
 */
public class UserPermissionCheckUtil {

    public static String generatePermission(Long userId, String password, String key){
        String sourceStr = userId + password + key;
        String md5 = DigestUtils.md5DigestAsHex(sourceStr.getBytes());
        return Base64Utils.encodeToString(md5.getBytes());
    }
}
