package com.example.hellospring.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Getter @Setter
@ToString
@Component
@Scope(value= WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo {
    private static final long serialVersionUID = 1L;

    private Long userID;
    private String userNm;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
