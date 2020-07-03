package com.hcbxwy.snail.common.config;

import com.hcbxwy.snail.common.interceptor.AuthenticationInterceptor;
import com.hcbxwy.snail.common.interceptor.ResultResponseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web mvc 自定义配置
 *
 * @author Billson
 * @date 2020/6/30 10:52
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 权限拦截器
        this.excludePathPatterns(registry.addInterceptor(new AuthenticationInterceptor()));
        // 统一接口返回格式拦截器
        this.excludePathPatterns(registry.addInterceptor(new ResultResponseInterceptor()));
    }

    /**
     * 配置需要拦截的 URL
     *
     * @param registration 拦截注册器
     * @author Billson
     * @date 2020/7/2 8:37 上午
     */
    public void excludePathPatterns(InterceptorRegistration registration) {
        registration.addPathPatterns("/**");
    }
}
