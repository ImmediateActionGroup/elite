package com.gproom.elite.service;

import com.gproom.elite.common.dto.user.UserPermissionCheck;

/**
 * @author weixueshan
 * @data 2018/3/20 19:51
 * @desc
 */
public interface UserPermissionService {
    /**
     * 检查用户权限
     * @param pkey pkey 组成为 userid:md5(userid+password)
     * @return
     */
    boolean checkPermission(UserPermissionCheck pkey);
}
