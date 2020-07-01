package com.hcbxwy.snail.common.handler;

import com.hcbxwy.snail.common.annotation.DefaultResponse;
import com.hcbxwy.snail.common.entity.Result;
import com.hcbxwy.snail.common.interceptor.ResultResponseInterceptor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 接口返回响应体处理器
 *
 * @author Billson
 * @since 2019/9/10 20:29
 */
@ControllerAdvice
public class ResultResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        HttpServletRequest request = getRequestAttributes().getRequest();
        DefaultResponse defaultResponse =
                (DefaultResponse) request.getAttribute(ResultResponseInterceptor.RESULT_RESPONSE);
        return defaultResponse != null;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        DefaultResponse defaultResponse = (DefaultResponse) getRequestAttributes().getRequest()
                .getAttribute(ResultResponseInterceptor.RESULT_RESPONSE);
        Class<?> resultClazz = defaultResponse.value();
        if (resultClazz.isAssignableFrom(Result.class)) {
            if (body instanceof Result) {
                return body;
            }
            return Result.success(body);
        }
        return body;
    }

    public ServletRequestAttributes getRequestAttributes() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
    }
}
