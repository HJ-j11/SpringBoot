package com.example.hellospring.service;


import com.example.hellospring.controller.TestController;
import com.example.hellospring.repository.BoardRepository;
import com.example.hellospring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CommentRepository commentRepository;



}
