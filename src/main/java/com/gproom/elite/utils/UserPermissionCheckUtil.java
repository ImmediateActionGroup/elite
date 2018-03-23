package com.gproom.elite.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午11:23
 */
public class UserPermissionCheckUtil {

    public static String generatePermission(String username, String password, String key){
        String sourceStr = username + password + key;
        String md5 = DigestUtils.md5DigestAsHex(sourceStr.getBytes());
        String aim = username + ":" + md5;
        return Base64Utils.encodeToString(aim.getBytes());
    }
}
