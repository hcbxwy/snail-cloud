package com.hcbxwy.snail.example.user.service;

import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.example.user.pojo.entity.UserDO;

/**
 * 用户模块接口定义类
 *
 * @author Billson
 * @date 2020/6/30 15:04
 */
public interface UserService {

    /**
     * 根据主键id查询用户信息
     *
     * @param id 主键id
     * @return com.hcbxwy.snail.example.user.pojo.entity.UserDO
     * @author Billson
     * @date 2020/6/30 15:11
     */
    UserDO getById(String id);

    /**
     * 根据原始密码和盐获取加密后的密码
     *
     * @param originPwd 原始密码
     * @param salt 盐
     * @return java.lang.String
     * @author Billson
     * @date 2020/6/30 15:20
     */
    String getPassword(String originPwd, String salt);

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return com.hcbxwy.snail.example.user.pojo.entity.UserDO
     * @author Billson
     * @date 2020/6/30 16:54
     */
    UserDO getByUsername(String username);

    LoginUser getLoginUserTest();

}
