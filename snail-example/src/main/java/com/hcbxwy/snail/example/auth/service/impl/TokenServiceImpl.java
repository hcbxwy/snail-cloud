package com.hcbxwy.snail.example.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hcbxwy.snail.example.auth.service.TokenService;
import com.hcbxwy.snail.example.common.JwtConstant;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Token 接口实现类
 *
 * @author Billson
 * @date 2020/6/30 11:02
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(String userId, String password, Object data) {
        return JWT.create()
                .withAudience(userId)
                // 有效期1小时
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .withClaim("data", JSONObject.toJSONString(data))
                .sign(Algorithm.HMAC256(JwtConstant.PRIVATE_SECRET));
    }
}
