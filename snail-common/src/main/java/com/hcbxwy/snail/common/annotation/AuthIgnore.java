package com.hcbxwy.snail.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 忽略权限校验注解
 *
 * @author Billson
 * @date 2020/6/29 21:03
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthIgnore {
    boolean ignore() default true;
}
