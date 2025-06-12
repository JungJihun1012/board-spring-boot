package com.example.demo.view.service;

import com.example.demo.jpa.entity.BoardEntity;
import com.example.demo.view.vo.BoardResVO;
import com.example.demo.view.vo.BoardSaveResVO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface BoardService {
    ResponseEntity<List<BoardEntity>> pathSelectBoard();
    ResponseEntity<BoardSaveResVO> selectOptionalIndexBoard(int idx);
    ResponseEntity<BoardEntity> insertBoard(BoardResVO vo);
    ResponseEntity<BoardResVO> deleteBoard(Integer idx);
    ResponseEntity<BoardEntity> updateBoard(BoardSaveResVO vo, int idx);
}
