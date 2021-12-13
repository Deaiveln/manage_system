package com.zxh.manage.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zxh.manage.resp.UserResp;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.Map;

/**
 * @author zxh
 * @create 2021-11-22-13:47
 * @statement 用于生成token和验证token的工具类
 */
public class JWTUtil {
    /**
     * 生命周期为24小时，单位是毫秒
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
    /**
     * 密钥
     */
    private static final String SECRET = "de@#@dadzfgersd44534w5ser";

    /**
     * 生成token
     * @param map
     * @return
     */
    public static String getToken(Map<String,Object> map) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //id,user_name,user_real_name,user_sex,dept_id,user_mobile
        return JWT.create()
                .withClaim("id",(Long) map.get("id"))
                // 五分钟后token过期
                .withExpiresAt(date)
                // token 的密钥
                .sign(Algorithm.HMAC256(SECRET));

    }


    /**
     * 校验token并返回DecodedJWT
     * @param token
     * @return DecodedJWT
     */
    public static DecodedJWT checkSign(String token) {
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
        return verify;
    }
}
