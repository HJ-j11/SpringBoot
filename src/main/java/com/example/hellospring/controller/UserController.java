package com.example.hellospring.controller;


import com.example.hellospring.entity.User;
import com.example.hellospring.login.JoinForm;
import com.example.hellospring.login.LoginForm;
import com.example.hellospring.login.SessionConstants;
import com.example.hellospring.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private TestService testService;

    @GetMapping("/")
    public String Home() {
        return "index";
    }

    @GetMapping("/join")
    public String joinMember(Model model) {
        JoinForm joinForm = new JoinForm();
        model.addAttribute("joinForm", joinForm);
        return "joinPage";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute JoinForm joinForm, BindingResult bindingResult, HttpServletRequest request) {

        return "index";
    }

    @GetMapping("/login")
    public String LoginForm(Model model) {
        LoginForm loginForm = new LoginForm();
        model.addAttribute("loginForm", loginForm);
        return "loginPage";
    }

    @PostMapping("/login")
    public String Login(@ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            return "loginPage";
        }

        User loginUser = testService.Login(loginForm.getLoginId(), loginForm.getPassword());

        if(loginUser == null) {
            bindingResult.reject("loginFail", "Invalid Id or Password you input");
            return "loginPage";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_USER, loginUser);
        return "sample";
    }

    @PostMapping("/logout")
    public String Logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return "loginPage";
    }

    @GetMapping("/err")
    public String errPage() {
        return "errPage";
    }

    @GetMapping("/mypage")
    public String myPage() {
        return "myPage";
    }
}