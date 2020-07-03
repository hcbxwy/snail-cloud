package com.hcbxwy.snail.example.demo.controller.service;

import com.hcbxwy.snail.common.entity.LoginUser;

/**
 * Demo 接口定义类
 *
 * @author Billson
 * @date 2020/6/30 17:30
 */
public interface DemoService {

    /**
     * 获取当前登录信息
     *
     * @return com.hcbxwy.snail.common.entity.LoginUserDTO
     * @author Billson
     * @date 2020/6/30 17:32
     */
    LoginUser getLoginInfo();
}
