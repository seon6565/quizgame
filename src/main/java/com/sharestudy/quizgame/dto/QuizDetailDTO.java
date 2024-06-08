package com.sharestudy.quizgame.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizDetailDTO {
    private int detailIdx;
    private String category;
    private int order;
    private int timer;
    private int score;
    private String question;
    private String comment;
    private String answer;
    private String quizIdx;
    private int oxIdx;
    private String ocomment;
    private String xcomment;
    private int blankIdx;
    private String blank;
    private int descIdx;
    private int descMin;
    private int mulIdx;
    private String mulImg;
    private String mulTitle;
}
