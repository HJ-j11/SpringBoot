package com.example.hellospring.service;


import com.example.hellospring.entity.Board;
import com.example.hellospring.repository.BoardRepository;
import com.example.hellospring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CommentRepository commentRepository;

    public List<Board> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    };

    public Optional<Board> getOneBoard(Long id) {
        Optional<Board> board= boardRepository.findById(id);
        return board;
    }

    @Transactional
    public void postNewBoard(@RequestBody Board board) {
        boardRepository.save(board);
    }
    
}
