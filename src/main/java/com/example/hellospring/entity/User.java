package com.example.hellospring.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    @Column(name="user_idx")
    private long idx;

    private String id;
    private String password;

    private String name;

    private String phone;



}
