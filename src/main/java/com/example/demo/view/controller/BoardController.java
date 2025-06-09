package com.example.demo.view.controller;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.view.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<BoardEntity>> selectUser() {
        return boardService.getUser();
    }
    @GetMapping("/idx")
    public ResponseEntity<BoardEntity> selectGetIdx(@RequestParam("index") int idx) {
        return boardService.getIdx(idx);
    }

}
