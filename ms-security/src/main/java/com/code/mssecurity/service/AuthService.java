package com.code.mssecurity.service;

import com.code.mssecurity.aggregates.request.SignInRequest;
import com.code.mssecurity.aggregates.request.SignUpRequest;
import com.code.mssecurity.aggregates.response.SignInResponse;
import com.code.mssecurity.entity.User;

import java.util.List;

public interface AuthService {
    List<User> listUsers();

    User signUpUser(SignUpRequest signUpRequest);
    User signUpAdmin(SignUpRequest signUpRequest);

    SignInResponse signIn(SignInRequest signInRequest);
    SignInResponse generateNewTokenByRefreshToken(String refreshToken);

    Boolean validateToken(String token);
}
