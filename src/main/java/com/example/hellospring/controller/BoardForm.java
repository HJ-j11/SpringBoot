package com.example.hellospring.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class BoardForm {
    private String contents;
    private String title;
    private MultipartFile file;
}
