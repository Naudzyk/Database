package com.zhenya.ru.Datadase.security;

import com.zhenya.ru.Datadase.service.impl.PersonDetailsImpl;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.xml.datatype.Duration;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt_secret}")
    private String secret;
    @Value("${jwt_lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication){
        Date issuedDate = new Date();
        Date expiredDate = new Date(issuedDate.getTime() + lifetime);
        PersonDetailsImpl personDetails = (PersonDetailsImpl) authentication.getPrincipal();
        return
                Jwts.builder().setSubject((personDetails.getUsername())).setIssuedAt(issuedDate)
                        .expiration(expiredDate)
                        .signWith(SignatureAlgorithm.HS256,secret)
                        .compact();
    }

    public String getNameFromJwt(String token) {
        return extractAllClaims(token).getSubject();
    }
      private SecretKey signKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(signKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
