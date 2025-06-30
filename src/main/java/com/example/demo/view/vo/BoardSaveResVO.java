package com.example.demo.view.vo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BoardSaveResVO {
    private String title;
    private String content;
    private LocalDate updateYmd;
}
