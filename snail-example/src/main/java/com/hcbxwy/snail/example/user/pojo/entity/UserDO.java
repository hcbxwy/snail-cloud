package com.hcbxwy.snail.example.user.pojo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户 DO
 *
 * @author Billson
 * @date 2020/6/30 15:08
 */
@Data
@Accessors(chain = true)
public class UserDO {

    private String id;
    private String username;
    private String password;
    private String salt;
}
