package com.gproom.elite.service.impl;

import com.gproom.elite.common.dto.user.UserAddDto;
import com.gproom.elite.common.dto.user.UserDto;
import com.gproom.elite.common.enums.BizTagEnums;
import com.gproom.elite.common.enums.DeleteFlagEnum;
import com.gproom.elite.model.User;
import com.gproom.elite.model.UserExample;
import com.gproom.elite.model.dao.UserMapper;
import com.gproom.elite.service.UserService;
import com.gproom.elite.utils.DateUtils;
import com.gproom.elite.utils.IdWorker;
import com.gproom.elite.utils.UserPermissionCheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @Author xueshan.wei
 * @Date 2018/3/20 下午11:03
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseService implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Value("${permission.user-key}")
    private String permissionKey;

    @Override
    public void init() {
        this.idWorker = new IdWorker(this.idCenterId, BizTagEnums.USER.getValue());
    }

    @Override
    public UserDto findUserById(Long id) {
        if(id == null){
            return null;
        }
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Override
    public String getMd5Permission(Long id) {
        UserDto userDto = findUserById(id);
        if(userDto == null){
            return null;
        }
        return UserPermissionCheckUtil.generatePermission(userDto.getUsername(), userDto.getPassword(), permissionKey);
    }

    @Override
    public boolean addUser(UserAddDto userAddDto) {

        // TODO: 2018/3/20 参数校验
        User user = assembleInsertUser(userAddDto);

        int result = userMapper.insert(user);
        if(result > 0){
            return true;
        }
        return false;
    }

    private User assembleInsertUser(UserAddDto userAddDto){
        User user = new User();
        user.setId(generateId());
        user.setUsername(userAddDto.getUsername());
        String md5Password = new String(DigestUtils.md5DigestAsHex(userAddDto.getPassword().getBytes()));
        user.setPassword(md5Password);
        Date now = DateUtils.getNow();
        user.setCreatedTime(now);
        user.setLastModifyTime(now);
        user.setDeleteFlag(DeleteFlagEnum.FAlSE.getValue());
        return user;
    }

    @Override
    public UserDto findUserByUsername(String username) {
        if(!StringUtils.hasText(username)){
            return null;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username)
                .andDeleteFlagEqualTo(DeleteFlagEnum.FAlSE.getValue());

        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size() > 0){
            return assemble(users.get(0));
        }
        return null;
    }

    private UserDto assemble(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
