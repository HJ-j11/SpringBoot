package com.example.hellospring.controller;


import com.example.hellospring.entity.Board;
import com.example.hellospring.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {
    @Autowired
    TestService testService;

    @GetMapping("/lists")
    public String getSampleList(Model model) {
        List<Board> boardList = testService.getBoards();
        model.addAttribute("boardList", boardList);
        return "boardList";
    }

    @GetMapping("/lists/write")
    public String writeNewBoard() {
        return "newBoard";
    }

    @GetMapping("/list/{id}")
    public String getOneBoard(@PathVariable Long id, Model model) {
        Optional<Board> board = testService.getOneBoard(id);
        model.addAttribute("board", board);
        return "board";
    }

    @PostMapping("/list/new")
    public void postNewBoard(@RequestBody Board board) {
        testService.postNewBoard(board);
    }
}
