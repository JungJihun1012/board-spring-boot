package com.example.demo.view.controller;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.view.service.BoardService;
import com.example.demo.view.vo.BoardResVO;
import com.example.demo.view.vo.BoardSaveResVO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;}

    @GetMapping("/user")
    public ResponseEntity<List<BoardEntity>> selectUser() {

        return boardService.getUser();
    }
    @GetMapping("/idx")
    public ResponseEntity<BoardEntity> selectGetIdx(@RequestParam("index") int idx) {
        return boardService.getIdx(idx);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<BoardEntity> deleteGetIdx(@RequestParam("index") int idx) {
        return boardService.deleteBoard(idx);
    }
    @PostMapping("/save")
    public ResponseEntity<BoardEntity> getInsert(@RequestBody BoardResVO boardResVO) {
        if (
                boardResVO == null ||
                        boardResVO.getTitle().isBlank() ||
                        boardResVO.getContent().isBlank() ||
                        boardResVO.getTitle() == null ||
                        boardResVO.getContent() == null
        ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        BoardEntity saveEntity = boardService.saveBoard(boardResVO).getBody();
        return ResponseEntity.ok(saveEntity);
    }
    @PutMapping("update/{index}")
    public ResponseEntity<BoardEntity> updateBoard(@RequestBody BoardResVO boardResVO) {
        return boardService.saveBoard(boardResVO);

    }
}

