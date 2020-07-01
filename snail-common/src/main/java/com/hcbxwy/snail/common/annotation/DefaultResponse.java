package com.hcbxwy.snail.common.annotation;


import com.hcbxwy.snail.common.entity.Result;

import java.lang.annotation.*;

/**
 * 配置该注解，则接口返回值使用 Spring Boot默认值，即不做拦截处理
 *
 * @author Billson
 * @date 2020/7/1 20:42
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DefaultResponse {

    Class<?> value() default Result.class;
}
