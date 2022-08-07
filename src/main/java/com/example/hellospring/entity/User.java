package com.example.hellospring.entity;


import com.example.hellospring.login.JoinForm;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_idx")
    private long idx;

    private String id;
    private String password;

    private String name;

    private String role;

    @Builder
    public User(String id, String password, String name, String role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public User(String name) {
        this.name = name;
    }

    public User createUser(JoinForm joinForm) {
        User user = User.builder()
                .id(joinForm.getJoinId())
                .name(joinForm.getName())
                .password(joinForm.getPassword())
                .build();
        return user;
    }

}
