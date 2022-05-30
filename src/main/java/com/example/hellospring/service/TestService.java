package com.example.hellospring.service;


import com.example.hellospring.entity.Board;
import com.example.hellospring.entity.User;
import com.example.hellospring.repository.BoardRepository;
import com.example.hellospring.repository.CommentRepository;
import com.example.hellospring.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    private BoardRepository boardRepository;

    private CommentRepository commentRepository;
    private UserRepository userRepository;

    public List<Board> getBoards() {
        return boardRepository.findAll();
    };

    public Optional<Board> getOneBoard(Long id) {
        return boardRepository.findById(id);
    }
    //로그인 기능
    public User Login(String LoginId, String pwd) {
        return userRepository.findByLoginId(LoginId).filter(m -> m.getPassword().equals(pwd))
                .orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void postNewBoard(@RequestBody Board board) {
        boardRepository.save(board);
    }
    
}
