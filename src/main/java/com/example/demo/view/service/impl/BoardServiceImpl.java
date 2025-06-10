package com.example.demo.view.service.impl;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.jpa.repository.BoardRepository;
import com.example.demo.view.service.BoardService;
import com.example.demo.view.vo.BoardResVO;
import com.example.demo.view.vo.BoardSaveResVO;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    protected BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public ResponseEntity<List<BoardEntity>> getUser() {
        return ResponseEntity.ok(boardRepository.findAllByOrderByIndexAsc());
    }
    @Override
    public ResponseEntity<BoardEntity> getIdx(int idx) {
        return ResponseEntity.ok(boardRepository.findOneByIndex(idx));
    }
    @Override
    public ResponseEntity<BoardEntity> deleteBoard(int idx) {
        if(!boardRepository.existsById(String.valueOf(idx))) {
            return ResponseEntity.notFound().build();
        }
        boardRepository.deleteById(String.valueOf(idx));
        return ResponseEntity.noContent().build();
    }
    @Transactional
    @Override
    public ResponseEntity<BoardEntity> saveBoard(BoardResVO vo) {
        int index;

        if (vo.getIndex() != null) {
            BoardEntity existing = boardRepository.findOneByIndex(vo.getIndex());
            if (existing != null) {
                existing.setTitle(vo.getTitle());
                existing.setContent(vo.getContent());
                return ResponseEntity.ok(boardRepository.save(existing)); // update
            } else {
                index = vo.getIndex();
            }
        } else {
            BoardEntity last = boardRepository.findTopByOrderByIndexDesc();
            index = (last != null ? last.getIndex() : 0) + 1;
        }

        BoardEntity entity = new BoardEntity();
        entity.setIndex(index);
        entity.setTitle(vo.getTitle());
        entity.setContent(vo.getContent());

        return ResponseEntity.ok(boardRepository.save(entity)); // insert
    }

}
