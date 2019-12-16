package ks.ac.finalproject.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ks.ac.finalproject.domain.UserInfo;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey="wlrnjs";

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    private Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private boolean isTokenExpired(String token) {
        final Date expiration=getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserInfo userInfo) throws UnsupportedEncodingException {
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userInfo.getEmail())
                .claim("username", userInfo.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

}
