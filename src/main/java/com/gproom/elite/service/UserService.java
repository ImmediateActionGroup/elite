package com.gproom.elite.service;

import com.gproom.elite.common.dto.user.UserAddDto;
import com.gproom.elite.common.dto.user.UserDto;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午11:01
 */
public interface UserService {

    UserDto findUserById(Long id);

    String getMd5Permission(Long id);

    boolean addUser(UserAddDto userAddDto);
}
