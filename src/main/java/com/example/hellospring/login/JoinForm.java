package com.example.hellospring.login;


import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class JoinForm {

    private String name;
    private String joinId;
    private String password;

}
