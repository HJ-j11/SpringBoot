package com.example.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/sample")
    public String sample(Model model) {
        model.addAttribute("name","Kim");
        return "sample";
    }

}
