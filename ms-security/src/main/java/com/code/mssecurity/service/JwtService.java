package com.code.mssecurity.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {
    String extractUsername(String token);

    String generateToken(UserDetails userDetails);
    String generateRefreshToken(UserDetails userDetails, Map<String, Object> claims);

    Boolean validateToken(String token, UserDetails userDetails);
    Boolean isRefreshToken(String token);
}
