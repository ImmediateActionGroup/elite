package com.gproom.elite.utils;

import com.gproom.elite.common.dto.user.UserPermissionCheck;
import com.gproom.elite.common.user.UserPrincipal;
import com.gproom.elite.service.UserPermissionService;
import org.springframework.util.Assert;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

/**
 * @author weixueshan
 * @data 2018/3/20 19:49
 * @desc
 */
public class PermissionChecker {
    private static final String SPLIT_STR = ":";
    private UserPermissionService userPermissionService;

    public PermissionChecker(UserPermissionService userPermissionService) {
        Assert.notNull(userPermissionService, "userPermissionService can't be null");
        this.userPermissionService = userPermissionService;
    }

    public boolean checkPermission(String pkey){
        UserPermissionCheck userPermissionCheck = parseUserPermissionCheck(pkey);
        if(!userPermissionCheck.isParseResult()){
            return false;
        }
        UserPrincipalContextHolder.setUserPrincipal(UserPrincipal.builder()
                .userId(userPermissionCheck.getUserId())
                .username(userPermissionCheck.getUserName())
                .userPkey(pkey)
                .build());
        return userPermissionService.checkPermission(userPermissionCheck);
    }

    private UserPermissionCheck parseUserPermissionCheck(String pkey){
        UserPermissionCheck userPermissionCheck = new UserPermissionCheck();
        userPermissionCheck.setParseResult(false);

        if(!StringUtils.hasText(pkey)){
            return userPermissionCheck;
        }

        String decodeStr = new String(Base64Utils.decodeFromString(pkey));

        String [] splitStr = StringUtils.split(pkey, SPLIT_STR);
        if(splitStr != null && splitStr.length != 3){
            return userPermissionCheck;
        }
        try{
            userPermissionCheck.setUserId(Long.parseLong(splitStr[0]));
        }catch (Exception e){
            return userPermissionCheck;
        }
        userPermissionCheck.setUserName(splitStr[1]);
        userPermissionCheck.setMd5(splitStr[2]);
        userPermissionCheck.setParseResult(true);
        return userPermissionCheck;
    }
}
