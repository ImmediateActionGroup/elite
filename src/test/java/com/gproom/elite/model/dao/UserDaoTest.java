package com.gproom.elite.model.dao;

import com.gproom.elite.EliteApplicationTests;
import com.gproom.elite.common.enums.DeleteFlagEnum;
import com.gproom.elite.model.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午10:34
 */
public class UserDaoTest extends EliteApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception{
        User user = new User();
        Date now = new Date();

        user.setDeleteFlag(DeleteFlagEnum.FAlSE.getValue());
        user.setUsername("nickname");
        user.setPassword("hahaha");
        user.setCreatedTime(now);
        user.setLastModifyTime(now);
        user.setId(1000L);
        int num = userMapper.insert(user);
        if(num > 0){
            System.out.println("插入成功");
        }
    }
}
