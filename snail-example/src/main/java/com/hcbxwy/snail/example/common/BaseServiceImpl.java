package com.hcbxwy.snail.example.common;

import com.hcbxwy.snail.example.user.pojo.dto.LoginUserDTO;
import com.hcbxwy.snail.example.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础抽象接口实现类
 *
 * @author Billson
 * @date 2020/6/30 16:41
 */
public abstract class BaseServiceImpl {

    @Autowired
    protected LoginService loginService;
    @Autowired
    protected HttpServletRequest request;

    protected LoginUserDTO getLoginUser() {
        return loginService.getLoginUser(request);
    }

    protected String getLoginUserId() {
        return getLoginUser().getUserId();
    }
}
