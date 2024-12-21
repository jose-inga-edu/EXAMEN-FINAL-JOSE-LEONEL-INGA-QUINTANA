package com.code.mssecurity.service.impl;

import com.code.mssecurity.aggregates.constants.Constants;
import com.code.mssecurity.aggregates.request.SignInRequest;
import com.code.mssecurity.aggregates.request.SignUpRequest;
import com.code.mssecurity.aggregates.response.SignInResponse;
import com.code.mssecurity.entity.Role;
import com.code.mssecurity.entity.RoleEnum;
import com.code.mssecurity.entity.User;
import com.code.mssecurity.repository.RoleRepository;
import com.code.mssecurity.repository.UserRepository;
import com.code.mssecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User signUpUser(SignUpRequest signUpRequest) {
        User user = getUserEntity(signUpRequest);
        user.setRoles(Collections.singleton(getRole(RoleEnum.USER)));
        return userRepository.save(user);
    }

    @Override
    public User signUpAdmin(SignUpRequest signUpRequest) {
        User user = getUserEntity(signUpRequest);
        Set<Role> roles = new HashSet<>();
        roles.add(getRole(RoleEnum.ADMIN));
        roles.add(getRole(RoleEnum.USER));
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public SignInResponse signIn(SignInRequest signInRequest) {
        return null;
    }

    @Override
    public SignInResponse generateNewTokenByRefreshToken(String refreshToken) {
        return null;
    }

    @Override
    public Boolean validateToken(String token) {
        return false;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    private Role getRole(RoleEnum role){
        return roleRepository
                .findByName(role.name())
                .orElseThrow(() -> new RuntimeException("ROLE NOT FOUND"));
    }

    private User getUserEntity(SignUpRequest signUpRequest) {
        return User.builder()
                .name(signUpRequest.getName())
                .lastname(signUpRequest.getLastname())
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .isAccountNonExpired(Constants.STATUS_ACTIVE)
                .isAccountNonLocked(Constants.STATUS_ACTIVE)
                .isCredentialsNonExpired(Constants.STATUS_ACTIVE)
                .isEnabled(Constants.STATUS_ACTIVE)
                .build();
    }
}
