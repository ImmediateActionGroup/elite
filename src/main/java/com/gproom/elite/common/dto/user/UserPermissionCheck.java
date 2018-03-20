package com.gproom.elite.common.dto.user;

import lombok.Data;

/**
 * @author weixueshan
 * @data 2018/3/20 20:05
 * @desc
 */
@Data
public class UserPermissionCheck {
    private Long userId;
    private String userName;
    private String md5;
    private boolean parseResult;

}
