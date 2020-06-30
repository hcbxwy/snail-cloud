package com.hcbxwy.snail.example.user.pojo.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录 VO
 *
 * @author Billson
 * @date 2020/6/30 15:34
 */
@Data
public class LoginVO {

    @NotBlank(message = "用户名必填")
    private String username;
    @NotBlank(message = "密码必填")
    private String password;
}
