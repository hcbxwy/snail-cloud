package com.hcbxwy.snail.common.interceptor;

import cn.hutool.core.bean.BeanUtil;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hcbxwy.snail.common.annotation.AuthIgnore;
import com.hcbxwy.snail.common.constant.RequestHeaderConstant;
import com.hcbxwy.snail.common.entity.LoginUser;
import com.hcbxwy.snail.common.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

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
        String token = request.getHeader(RequestHeaderConstant.X_ACCESS_TOKEN);
        if (token == null) {
            log.error("Header无token");
            return false;
        }

        DecodedJWT jwt;
        try {
            // 校验token
            jwt = JwtUtil.verify(token);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("无效token");
        }
        // 从jwt中获取登录用户信息，并放入request
        Map<String, Object> dataMap = jwt.getClaim("dataMap").asMap();
        if (Objects.nonNull(dataMap) && !dataMap.isEmpty()) {
            LoginUser loginUser = BeanUtil.mapToBean(dataMap, LoginUser.class, true);
            loginUser.setToken(token);
            request.setAttribute("loginUser", loginUser);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
