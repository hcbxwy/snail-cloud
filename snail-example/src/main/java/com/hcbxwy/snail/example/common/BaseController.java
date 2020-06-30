package com.hcbxwy.snail.example.common;

import com.hcbxwy.snail.example.user.pojo.dto.LoginUserDTO;
import com.hcbxwy.snail.example.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础抽象 Controller
 *
 * @author Billson
 * @date 2020/6/30 15:30
 */
public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected LoginService loginService;

    protected LoginUserDTO getLoginUser() {
        return loginService.getLoginUser(request);
    }

    protected String getLoginUserId() {
        return loginService.getLoginUser(request).getUserId();
    }
}
