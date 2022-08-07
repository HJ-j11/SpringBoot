package com.example.hellospring.controller;

import com.example.hellospring.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/manage/api/user")
public class UserManagerController {

    private static final List<User> users = Arrays.asList(
            new User("Tom"),
            new User("Lee"),
            new User("Kim")
    );

    @GetMapping
    public List<User> getAllUsers() {
        System.out.println("ALL USERS");
        return users;
    }

    @PostMapping
    public void registerUser(@RequestBody User user) {
        System.out.println("New User Added");
        System.out.println(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        System.out.println("Delete User");
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
        System.out.println("Update User");
        System.out.println(String.format("%s %s", user, user));
    }
}
