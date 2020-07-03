package com.hcbxwy.snail.example.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.common.base.BaseServiceImpl;
import com.hcbxwy.snail.example.user.pojo.entity.UserDO;
import com.hcbxwy.snail.example.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户模块接口实现类
 *
 * @author Billson
 * @date 2020/6/30 15:05
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public UserDO getById(String id) {
        UserDO userDO = new UserDO();
        userDO.setId(id)
                .setUsername("test")
                .setPassword("123456")
                .setSalt("321");
        return userDO;
    }

    @Override
    public String getPassword(String originPwd, String salt) {
        return SecureUtil.md5(originPwd + salt);
    }

    @Override
    public UserDO getByUsername(String username) {
        final String name = "test";
        if (Objects.equals(username, name)) {
            UserDO userDO = new UserDO();
            userDO.setId("1")
                    .setUsername("test")
                    .setPassword("c5bf1a3125468e39365a8a23db076be2")
                    .setSalt("321");
            return userDO;
        }
        return null;
    }

    @Override
    public LoginUser getLoginUserTest() {
        return super.getLoginUser();
    }

}
