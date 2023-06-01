package com.example.medical_platform.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

public class JWTUtil {
    private static String SING="This_a_order";//密令
    public static String createToken(Map<String,String> payload){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.SECOND,12000);//密令时间为12000s
        //创建jwt builder
        JWTCreator.Builder builder= JWT.create().withExpiresAt(calendar.getTime());//指定令牌过期时间
        //builder.withClaim("username","admin");
        //builder.withClaim("id","1");
        Set<String> keys=payload.keySet();
        for(String key:keys){
            String value=payload.get(key);
            builder.withClaim(key,value);
        }
        String token=builder.sign(Algorithm.HMAC256(SING));
        return token;
    }

    public static DecodedJWT verifyToken(String token){
        //验证token的合法性
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(SING)).build();
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        return decodedJWT;
    }
}
