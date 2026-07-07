package com.example.Reviewrave.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.Reviewrave.Entity.AccountEntity;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
//import io.jsonwebtoken.security.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long exp;

    public String generateToken(AccountEntity acc) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .subject(acc.getEmail())
                .claims(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(
                        new Date(System.currentTimeMillis() + exp))
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(
                secret.getBytes(StandardCharsets.UTF_8));
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaim(
            String token,
            Function<Claims, T> resolver) {
        return resolver.apply(extractAllClaims(token));
    }
    public String extractUsername(String token) {

        return extractClaim(token,Claims::getSubject);
    }
    private boolean isTokenExpired(
            String token) {
        return extractClaim(token,Claims::getExpiration)
                .before(new Date());
    }
    public boolean isTokenValid(
            String token,
            UserDetails userDetails) {
        String username =extractUsername(token);
        return username.equals(
                userDetails.getUsername())
                &&
                !isTokenExpired(token);
    }
}
