package com.example.demo.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BOARD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @Column(name = "index")
    private int index;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
}
