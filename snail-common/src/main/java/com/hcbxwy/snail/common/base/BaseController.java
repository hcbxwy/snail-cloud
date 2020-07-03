package com.hcbxwy.snail.common.base;

import com.hcbxwy.snail.common.entity.LoginUser;
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

    protected LoginUser getLoginUser() {
        return (LoginUser) request.getAttribute("loginUser");
    }

    protected String getLoginUserId() {
        return getLoginUser().getUserId();
    }
}
