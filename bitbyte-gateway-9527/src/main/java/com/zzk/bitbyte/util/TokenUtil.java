package com.zzk.bitbyte.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import sun.misc.BASE64Encoder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Token工具类,基于jwt
 *
 * @Author: zzk
 * @Date: 2020-01-29 18:52
 */
@Data
public class TokenUtil {

    /**
     * 创建token
     *
     * @param userDetails 用户信息
     * @param exp         超时时间,单位/秒
     */
    public static String createToken(UserDetails userDetails, long exp) throws Exception {
        Util.validateObj(userDetails, "用户信息");
        Util.validateStr(userDetails.getUsername(), "用户ID");
        BASE64Encoder encoder = new BASE64Encoder();
        String password=userDetails.getPassword();
        return Jwts.builder().setExpiration(Date.from(LocalDateTime.now().plusSeconds(exp).atZone(ZoneId.systemDefault()).toInstant()))
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setHeaderParam("pwd",password)
                .signWith(SignatureAlgorithm.HS512, encoder.encode(password.getBytes()))
                .compact();
    }

    /**
     * 验证token
     * @throws JWTVerificationException
     */
    public static void validateToken(DecodedJWT decodedJWT,UserDetails userDetails) throws JWTVerificationException {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC512(userDetails.getPassword()))
                .withSubject(decodedJWT.getSubject())
                .build();
        jwtVerifier.verify(decodedJWT);
    }
}
