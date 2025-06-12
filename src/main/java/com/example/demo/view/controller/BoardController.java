package com.example.demo.view.controller;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.view.service.BoardService;
import com.example.demo.view.vo.BoardResVO;
import com.example.demo.view.vo.BoardSaveResVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/patchSelect")
    public ResponseEntity<List<BoardEntity>> pathSelectBoard() {
        return boardService.pathSelectBoard();
    }
    @GetMapping("/select/{idx}")
    public ResponseEntity<BoardSaveResVO> selectOptionalIndexBoard(@PathVariable int idx) {
        return boardService.selectOptionalIndexBoard(idx);
    }
    @DeleteMapping("/delete/{idx}")
    public ResponseEntity<BoardResVO> deleteBoard(@PathVariable Integer idx) {
        return boardService.deleteBoard(idx);
    }
    @PostMapping("/insert")
    public ResponseEntity<BoardEntity> insertBoard(@RequestBody BoardResVO boardResVO) {
        if (boardResVO == null || boardResVO.getTitle().isBlank() || boardResVO.getContent().isBlank() || boardResVO.getTitle() == null || boardResVO.getContent() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        BoardEntity saveEntity = boardService.insertBoard(boardResVO).getBody();
        return ResponseEntity.ok(saveEntity);
    }
    @PutMapping("/update/{index}")
    public ResponseEntity<BoardEntity> updateBoard(@PathVariable int index, @RequestBody BoardSaveResVO vo) {
        return boardService.updateBoard(vo, index);
    }
}

