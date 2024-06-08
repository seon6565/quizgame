package com.sharestudy.quizgame.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizReportDTO {
    private int reportIdx;
    private int roomIdx;
    private String sName;
    private String sQuestion;
    private String sAnswer;
    private String sAnswerYN;
    private int sScore;
    private LocalDateTime regDate;
}
