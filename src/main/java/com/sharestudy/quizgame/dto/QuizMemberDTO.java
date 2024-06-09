package com.sharestudy.quizgame.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizMemberDTO {
    private int quizMemberIdx;
    private int roomIdx;
    private String sName;
    private String sPassword;
    private String sImgUrl;
    private int sCorrectCount;
    private int sAnswerCount;
    private int sTotalScore;
    private LocalDateTime regDate;
}
