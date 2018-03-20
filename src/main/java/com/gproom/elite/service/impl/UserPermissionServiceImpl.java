package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.user.UserPermissionCheck;
import com.gproom.elite.service.UserPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author weixueshan
 * @data 2018/3/20 19:59
 * @desc
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    @Override
    public boolean checkPermission(UserPermissionCheck pkey) {
        return true;
    }
}
