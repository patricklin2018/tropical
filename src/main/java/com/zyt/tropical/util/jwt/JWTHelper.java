package com.zyt.tropical.util.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zyt.tropical.exception.SysException;
import com.zyt.tropical.pojo.dto.AuthInfoDTO;
import com.zyt.tropical.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.security.auth.message.AuthException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: JWT 工具类
 * @Author: 林辉煌 huihuang.lin@luckincoffee.com
 * @Date: 2019/8/3 13:43
 **/
@Component
public class JWTHelper {

    @Autowired
    private JWTConfig jwtConfig;

    private JWTHelper() {}

    /**
     * 构建JWT令牌
     *
     * @param authInfoDTO 授权信息
     * @param ttlSeconds  有效期，单位为秒
     * @return JWT令牌
     */
    public String create(AuthInfoDTO authInfoDTO, long ttlSeconds) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", jwtConfig.getAlg());
        headers.put("type", jwtConfig.getType());
        Map<String, String> payload = ObjectUtil.objToMap(authInfoDTO);
        JWTCreator.Builder builder = JWT.create().withHeader(headers);
        for (Map.Entry<String, String> entry : payload.entrySet()) {
            builder.withClaim(entry.getKey(), entry.getValue());
        }
        if (ttlSeconds >= 0) {
            Date expiredAt = new Date((new Date()).getTime() + ttlSeconds * 1000);
            builder.withExpiresAt(expiredAt);
        }
        String token;
        try {
            token = builder.sign(Algorithm.HMAC256(jwtConfig.getPrivateSecret()));
        } catch (UnsupportedEncodingException e) {
            throw new SysException("令牌生成失败");
        }
        return token;
    }

    /**
     * 解析JWT令牌
     *
     * @param token JWT令牌
     * @return 授权信息
     */
    public AuthInfoDTO parse(String token) throws AuthException {
        Assert.notNull(token);
        DecodedJWT decodedJWT;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtConfig.getPrivateSecret())).build();
            decodedJWT = verifier.verify(token);
        } catch (Exception e) {
            throw new AuthException("令牌非法");
        }
        Map<String, Claim> claims = decodedJWT.getClaims();
        AuthInfoDTO res = convertToAuthInfoDTO(claims);
        return res;
    }

    private AuthInfoDTO convertToAuthInfoDTO(Map<String, Claim> claims) {
        AuthInfoDTO authInfoDTO = new AuthInfoDTO();
        Method[] methods = AuthInfoDTO.class.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String field = method.getName().substring(3).toLowerCase();
                Claim claim = claims.get(field);
                try {
                    method.invoke(authInfoDTO, claim.asString());
                } catch (Exception e) {
                }
            }
        }
        return authInfoDTO;
    }

}
