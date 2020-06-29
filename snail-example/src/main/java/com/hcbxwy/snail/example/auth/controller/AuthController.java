package com.hcbxwy.snail.example.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口权限控制类
 *
 * @author Billson
 * @date 2020/6/29 20:52
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/token")
    public String getToken() {
        return "获取jwt-token";
    }
}
