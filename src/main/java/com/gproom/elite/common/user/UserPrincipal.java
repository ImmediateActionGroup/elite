package com.gproom.elite.common.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author weixueshan
 * @data 2018/3/21 11:34
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPrincipal {
    private Long userId;
    private String username;
    private String userPkey;
}
