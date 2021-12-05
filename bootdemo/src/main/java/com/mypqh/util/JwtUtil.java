package com.mypqh.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64Codec;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

public class JwtUtil {
    private static String authJm = "wwery2064";

    public static String createJwt(Map py) {
        System.out.println("负荷的值：" + py);
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 在服务器定义的自己的密匙

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(authJm);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //set the JWT claims http://blog.csdn.net/buyaoshuohua1
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "H8256")
                .setClaims(py)
                .signWith(signatureAlgorithm, signingKey); //部分签名，用HS256加密
        return builder.compact();
    }

    public static Claims parseJwt(String jwt) {
        //密匙，跟生成token时对应一致
        if (jwt.split("\\.").length == 3) {
            String head = jwt.split("\\.")[0]; //头部
            String payload = jwt.split("\\.")[1]; //负荷

            System.out.println(Base64Codec.BASE64URL.decodeToString(payload));
            String sign = jwt.split("\\.")[2];//签名
            System.out.println(sign);

            JwsHeader claims1 = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(authJm))
                    .parseClaimsJws(jwt)
                    .getHeader();

            System.out.println("头部：" + claims1.toString());

            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(authJm))
                    .parseClaimsJws(jwt).getBody();
            //存储的是负荷的信息
            //传入负荷，再次调用返回签名，
            String signNew = createJwt(claims).split("\\.")[2];
            if (signNew.equals(sign)) {
                System.out.println("匹配一致，数据没有篡改");
            }
            return claims;
        } else {
            return null;
        }
    }

}
