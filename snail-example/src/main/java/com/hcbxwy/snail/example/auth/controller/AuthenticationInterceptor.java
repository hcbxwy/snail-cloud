package com.hcbxwy.snail.example.auth.controller;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.hcbxwy.snail.example.common.JwtConstant;
import com.hcbxwy.snail.example.user.pojo.dto.LoginUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 接口权限拦截器
 *
 * @author Billson
 * @date 2020/6/29 21:06
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 检查是否有@AuthIgnore注解，有则跳过认证
        if (method.isAnnotationPresent(AuthIgnore.class)) {
            AuthIgnore authIgnore = method.getAnnotation(AuthIgnore.class);
            if (authIgnore.ignore()) {
                return true;
            }
        }
        // 执行认证
        String token = request.getHeader("token");
        if (token == null) {
            log.error("Header无token");
            return false;
        }
        // 校验token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(JwtConstant.PRIVATE_SECRET)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("登录过期，请重新登录。");
        }
        // 从jwt中获取登录用户信息，并放入request
        DecodedJWT jwt = JWT.decode(token);
        String jsonStr = jwt.getClaim("data").asString();
        LoginUserDTO loginUserDTO = JSONObject.parseObject(jsonStr).toJavaObject(LoginUserDTO.class);
        request.setAttribute("loginUserDTO", loginUserDTO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
