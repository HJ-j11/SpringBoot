package com.example.hellospring.login;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;

@Data @Getter
public class LoginForm {
    private String LoginId;
    private String password;

}
