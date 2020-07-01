package com.hcbxwy.snail.common.interceptor;

import com.hcbxwy.snail.common.annotation.DefaultResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 接口返回响应体控制拦截器
 *
 * @author Billson
 * @date 2020/7/1 20:53
 */
@Component
public class ResultResponseInterceptor implements HandlerInterceptor {

    public static final String RESULT_RESPONSE = "DEFAULT_RESPONSE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            // 默认拦截，有@DefaultResponse注解的类和方法不拦截
            if (!clazz.isAnnotationPresent(DefaultResponse.class)) {
                request.setAttribute(RESULT_RESPONSE, clazz.getAnnotation(DefaultResponse.class));
            } else if (!method.isAnnotationPresent(DefaultResponse.class)) {
                request.setAttribute(RESULT_RESPONSE, method.getAnnotation(DefaultResponse.class));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // nothing to do
    }
}
