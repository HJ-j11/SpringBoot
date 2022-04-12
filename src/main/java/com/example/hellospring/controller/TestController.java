package com.example.hellospring.controller;


import com.example.hellospring.entity.Board;
import com.example.hellospring.entity.BoardStatus;
import com.example.hellospring.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TestController {
    @Autowired
    TestService testService;
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/lists")
    public String getSampleList(Model model) {
        List<Board> boardList = testService.getBoards();
        model.addAttribute("boardList", boardList);
        return "boardList";
    }

    @GetMapping("/lists/write")
    public String writeNewBoard(Model model) {
        model.addAttribute("board", new BoardForm());
        return "newBoard";
    }

    @GetMapping("/list/{id}")
    public String getOneBoard(@PathVariable Long id, Model model) {
        Optional<Board> board = testService.getOneBoard(id);
        model.addAttribute("board", board);
        return "board";
    }

    @PostMapping("/list/new")
    public void postNewBoard(@ModelAttribute BoardForm boardform) {
        String title = boardform.getTitle();
        String contents = boardform.getContents();
        MultipartFile file = boardform.getFile();

        logger.info(boardform.getContents());
        logger.info(boardform.getTitle());
        logger.info(boardform.getFile().getOriginalFilename());

        Board board = new Board(title, contents, new Date(), BoardStatus.LIST);

    }
}
