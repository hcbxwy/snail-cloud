package com.hcbxwy.snail.example.auth.service;

/**
 * Token 接口定义类
 *
 * @author Billson
 * @date 2020/6/30 11:00
 */
public interface TokenService {

    /**
     * 生成 token
     *
     * @param userId 用户id
     * @param password 密码
     * @param data 荷载数据
     * @return java.lang.String
     * @author Billson
     * @date 2020/6/30 11:01
     */
    String getToken(String userId, String password, Object data);
}
