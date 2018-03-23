package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.user.UserDto;
import com.gproom.elite.common.dto.user.UserPermissionCheck;
import com.gproom.elite.service.UserPermissionService;
import com.gproom.elite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

/**
 * @author weixueshan
 * @data 2018/3/20 19:59
 * @desc
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService {
    @Autowired
    private UserService userService;

    @Value("${permission.user-key}")
    private String permissionKey;

    @Override
    public boolean checkPermission(UserPermissionCheck userPermissionCheck) {
        if(userPermissionCheck == null || userPermissionCheck.isParseResult() == false){
            return false;
        }
        UserDto userDto = userService.findUserByUsername(userPermissionCheck.getUserName());
        if(userDto == null){
            return false;
        }
        return checkMd5(userPermissionCheck, userDto);
    }

    private boolean checkMd5(UserPermissionCheck userPermissionCheck, UserDto userDto){
        String sourceMd5 = DigestUtils.md5DigestAsHex((userDto.getUsername() + userDto.getPassword() + permissionKey).getBytes());
        if(sourceMd5.equals(userPermissionCheck.getMd5())){
            return true;
        }
        return false;
    }
}
