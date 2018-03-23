package com.gproom.elite.utils;

import com.gproom.elite.common.user.UserPrincipal;

/**
 * 用户 principal
 * @author weixueshan
 * @data 2018/3/21 11:32
 * @desc
 */
public class UserPrincipalContextHolder {
    private static ThreadLocal<UserPrincipal> userPrincipalHolder = new ThreadLocal<>();

    public static void setUserPrincipal(UserPrincipal userPrincipal){
        userPrincipalHolder.set(userPrincipal);
    }

    public static UserPrincipal getCurrentUserPrincipal(){
        return userPrincipalHolder.get();
    }
}
