package com.hcbxwy.snail.example.user.controller;

import com.hcbxwy.snail.common.annotation.AuthIgnore;
import com.hcbxwy.snail.common.base.BaseController;
import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.example.user.pojo.vo.LoginVO;
import com.hcbxwy.snail.example.user.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 登录模块 Controller
 *
 * @author Billson
 * @date 2020/6/30 16:48
 */
@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController extends BaseController {

    private final LoginService loginService;

    /**
     * 用户登录接口
     *
     * @param loginVO 登录信息
     * @return java.lang.String
     * @author Billson
     * @date 2020/6/30 15:39
     */
    @PostMapping
    @AuthIgnore
    public LoginUser login(@RequestBody @Valid LoginVO loginVO) {
        return loginService.login(loginVO);
    }

}
