package com.hcbxwy.snail.example.user.pojo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登录用户 DTO
 *
 * @author Billson
 * @date 2020/6/30 15:36
 */
@Data
@Accessors(chain = true)
public class LoginUserDTO {

    private String userId;
    private String username;
    private String token;
}
