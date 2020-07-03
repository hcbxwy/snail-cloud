package com.hcbxwy.snail.example.user.service;

import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.example.user.pojo.vo.LoginVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录模块接口定义类
 *
 * @author Billson
 * @date 2020/6/30 16:50
 */
public interface LoginService {

    /**
     * 用户登录接口
     *
     * @param loginVO 登录信息
     * @return java.lang.String
     * @author Billson
     * @date 2020/6/30 15:39
     */
    LoginUser login(LoginVO loginVO);

    /**
     * 从请求对象中获取当前登录用户信息
     *
     * @param request 请求对象
     * @return com.hcbxwy.snail.common.entity.LoginUserDTO
     * @author Billson
     * @date 2020/6/30 16:35
     */
    LoginUser getLoginUser(HttpServletRequest request);
}
