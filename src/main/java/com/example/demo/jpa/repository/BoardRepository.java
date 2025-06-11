package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    List<BoardEntity> findAllByOrderByIndexAsc();
    Optional<BoardEntity> findByIndex(int idx);
    BoardEntity getByIndex(int index);
}
