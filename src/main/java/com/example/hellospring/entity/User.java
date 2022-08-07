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
public class User {
    @Id
    private String id;
    private String password;
    private String username;
    private String role;


}
