package com.hcbxwy.snail.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登录用户
 *
 * @author Billson
 * @date 2020/6/30 15:36
 */
@Data
@Accessors(chain = true)
public class LoginUser {

    private String userId;
    private String username;
    private String token;
}
