package com.example.hellospring.service;


import com.example.hellospring.controller.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestController testController;

}
