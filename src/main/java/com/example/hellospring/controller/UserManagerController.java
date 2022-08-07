package com.example.hellospring.controller;

import com.example.hellospring.entity.User;
import com.example.hellospring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manage/api/user")
public class UserManagerController {

    private final UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAIN')")
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        System.out.println("ALL USERS");
        return allUsers;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user:write')")
    public void registerUser(@RequestBody User user) {
        System.out.println("New User Added");
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("Delete User");
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('user:write')")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println("Update User");
        System.out.println(String.format("%s %s", user, user));
    }
}
