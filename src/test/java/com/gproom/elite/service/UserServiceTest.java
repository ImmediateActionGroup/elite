package com.gproom.elite.service;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.common.dto.user.UserAddDto;
import com.gproom.elite.common.dto.user.UserDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午11:10
 */
public class UserServiceTest extends EliteApplicationTests{
    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById() throws Exception{
        UserDto userDto = userService.findUserById(1000L);

        System.out.println(userDto);
    }

    @Test
    public void testAddUser() throws Exception{
        UserAddDto userAddDto = UserAddDto.builder()
                .username("weixueshan")
                .password("hahaha")
                .build();

        boolean result = userService.addUser(userAddDto);
        System.out.println(result);
    }

    @Test
    public void testGetMd5Permission() throws Exception{
        Long userId = 61279727880785920L;
        System.out.println(userService.getMd5Permission(userId));
    }


}
