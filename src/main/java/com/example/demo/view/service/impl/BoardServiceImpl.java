package com.example.demo.view.service.impl;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.jpa.repository.BoardRepository;
import com.example.demo.view.service.BoardService;
import com.example.demo.view.vo.BoardResVO;
import com.example.demo.view.vo.BoardSaveResVO;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<List<BoardEntity>> pathSelectBoard() {
        return ResponseEntity.ok(boardRepository.findAllByOrderByIndexAsc());
    }
    @Override
    public ResponseEntity<BoardSaveResVO> selectOptionalIndexBoard(int idx) {
        BoardEntity entity = boardRepository.findByIndex(idx).orElseThrow(() -> new RuntimeException("데이터 없음"));
        BoardSaveResVO vo = new BoardSaveResVO();
        vo.setTitle(entity.getTitle());
        vo.setContent(entity.getContent());
        vo.setUpdateYmd(entity.getUpdateYmd());
        return ResponseEntity.ok(vo);
    }
    @Override
    public ResponseEntity<BoardResVO> deleteBoard(Integer idx) {
        if(!boardRepository.existsById(idx)) {
            return ResponseEntity.notFound().build();
        }
        boardRepository.deleteById(idx);
        return ResponseEntity.noContent().build();
    }
    @Transactional
    @Override
    public ResponseEntity<BoardEntity> insertBoard(BoardResVO vo) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(vo.getTitle());
        entity.setContent(vo.getContent());
        return ResponseEntity.ok(boardRepository.save(entity)); // insert
    }
    @Override
    public ResponseEntity<BoardEntity> updateBoard(BoardSaveResVO vo, int idx) {
        BoardEntity existing = boardRepository.getByIndex(idx);
        if (existing != null) {
            existing.setTitle(vo.getTitle());
            existing.setContent(vo.getContent());
        }
        return ResponseEntity.ok(boardRepository.save(existing));
    }

}
