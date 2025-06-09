package com.example.demo.view.service.impl;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.jpa.repository.BoardRepository;
import com.example.demo.view.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    protected BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public ResponseEntity<List<BoardEntity>> getUser() {
        return ResponseEntity.ok(boardRepository.findAll());
    }
    @Override
    public ResponseEntity<BoardEntity> getIdx(int idx) {
        return ResponseEntity.ok(boardRepository.findOneByIndex(idx));
    }
    @Override
    public ResponseEntity<BoardEntity> getSave() {
        return ResponseEntity.ok(boardRepository.save(new BoardEntity()));
    }
}
