package com.hcbxwy.snail.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 错误码
 *
 * @author Billson
 * @date 2020/7/1 20:17
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    /**
     * 一切 ok，操作成功
     */
    SUCCESS("00000", "操作成功"),
    USER_ERROR("A0001", "用户端错误"),
    SYSTEM_ERROR("B0001", "系统执行出错"),
    THIRD_ERROR("C0001", "调用第三方服务出错");

    private final String code;
    private final String msg;
}
