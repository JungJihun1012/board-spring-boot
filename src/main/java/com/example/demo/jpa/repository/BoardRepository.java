package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, String> {
    List<BoardEntity> findAllByOrderByIndexAsc();
    BoardEntity findOneByIndex(int index);
    BoardEntity findTopByOrderByIndexDesc();

}
