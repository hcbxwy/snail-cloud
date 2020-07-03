package com.hcbxwy.snail.example.user.controller;

import com.hcbxwy.snail.common.base.BaseController;
import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.example.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块 Controller
 *
 * @author Billson
 * @date 2020/6/30 15:29
 */
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("/getLoginUser")
    public LoginUser getUser() {
        return userService.getLoginUserTest();
    }
}
