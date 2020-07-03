package com.hcbxwy.snail.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.NonNull;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * JWT 工具类
 *
 * @author Billson
 * @date 2020/7/3 17:24
 */
public class JwtUtil {
    public static final String PRIVATE_SECRET = "1vVv%XK2OFMVP1GoGrC08kWegfdL9@4b";

    /**
     * 生成 Token
     *
     * @param userId 用户唯一标识
     * @param dataMap 载荷数据
     * @param expireDate 过期时间，默认有效期2小时
     * @return java.lang.String
     * @author Billson
     * @date 2020/7/3 17:29
     */
    public static String createToken(@NonNull String userId, Map<String, Object> dataMap, Date expireDate) {
        // 默认有效期两小时
        if (Objects.isNull(expireDate)) {
            expireDate = new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000);
        }
        return JWT.create()
                .withAudience(userId)
                .withExpiresAt(expireDate)
                .withClaim("dataMap", dataMap)
                .sign(Algorithm.HMAC256(PRIVATE_SECRET));
    }

    /**
     * 验证 Token
     * 
     * @param token 令牌
     * @return com.auth0.jwt.interfaces.DecodedJWT 
     * @author Billson
     * @date 2020/7/3 17:36
     */
    public static DecodedJWT verify(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(PRIVATE_SECRET)).build();
        return jwtVerifier.verify(token);
    }
}
