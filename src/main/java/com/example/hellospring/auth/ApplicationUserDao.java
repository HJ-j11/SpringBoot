package com.example.hellospring.auth;

import com.example.hellospring.security.CustomUserDetails;

import java.util.Optional;


public interface ApplicationUserDao {

    public Optional<CustomUserDetails> selectUserByUsername(String username);
}
