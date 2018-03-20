package com.gproom.elite.utils;

import com.gproom.elite.service.UserPermissionService;
import org.springframework.util.Assert;

/**
 * @author weixueshan
 * @data 2018/3/20 19:49
 * @desc
 */
public class PermissionCheck {

    private UserPermissionService userPermissionService;

    public PermissionCheck(UserPermissionService userPermissionService) {
        Assert.notNull(userPermissionService, "userPermissionService can't be null");
        this.userPermissionService = userPermissionService;
    }

    public boolean checkPermission(String pkey){
        return userPermissionService.checkPermission(pkey);
    }
}
