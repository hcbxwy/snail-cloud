package com.hcbxwy.snail.example.demo.controller.service;

import com.hcbxwy.snail.example.user.pojo.dto.LoginUserDTO;

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
     * @return com.hcbxwy.snail.example.user.pojo.dto.LoginUserDTO
     * @author Billson
     * @date 2020/6/30 17:32
     */
    LoginUserDTO getLoginInfo();
}
