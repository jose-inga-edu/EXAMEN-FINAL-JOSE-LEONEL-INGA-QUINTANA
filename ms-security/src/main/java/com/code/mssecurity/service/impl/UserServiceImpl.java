package com.code.mssecurity.service.impl;

import com.code.mssecurity.entity.User;
import com.code.mssecurity.repository.UserRepository;
import com.code.mssecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository
                        .findByEmail(username)
                        .orElseThrow(()-> new UsernameNotFoundException("USER NOT FOUND IN DATABASE"));
            }
        };
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
