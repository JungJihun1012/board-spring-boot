package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, String> {
    BoardEntity findOneByIndex(int index);
}
