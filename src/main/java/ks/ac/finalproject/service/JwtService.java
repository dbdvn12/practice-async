package ks.ac.finalproject.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ks.ac.finalproject.domain.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Slf4j
@Service("jwtService")
public class JwtService {
    public String generateToken(UserInfo userInfo) throws UnsupportedEncodingException {
        String jwt = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userInfo.getEmail())
                .claim("id", userInfo.getId())
                .setExpiration(new Date(System.currentTimeMillis() + 1 * (1000 * 60 * 60 * 24)))
                .signWith(SignatureAlgorithm.HS256, "wlrnjs".getBytes())
                .compact();
        return jwt;
    }
}
