package com.gproom.elite.common.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午11:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAddDto {
    private String username;
    private String password;
}
