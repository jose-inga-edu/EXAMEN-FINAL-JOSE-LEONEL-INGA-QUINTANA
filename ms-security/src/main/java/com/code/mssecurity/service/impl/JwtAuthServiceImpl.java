package com.code.mssecurity.service.impl;

import com.code.mssecurity.service.JwtAuthService;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Map;

public class JwtAuthServiceImpl implements JwtAuthService {
    @Value("${key.signature}")
    private String keySignature;

    @Override
    public String extractUsername(String token) {
        return "";
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return "";
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails, Map<String, Object> claims) {
        return "";
    }

    @Override
    public Boolean validateToken(String token, UserDetails userDetails) {
        return null;
    }

    @Override
    public Boolean isRefreshToken(String token) {
        return null;
    }

    private Key getSignKey(){
        byte[] key = Decoders.BASE64.decode(keySignature);
        return Keys.hmacShaKeyFor(key);
    }
}
