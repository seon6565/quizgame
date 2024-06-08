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
public class QuizRoomDTO {
    private int roomIdx;
    private int teacherIdx;
    private String teacherName;
    private String title;
    private String intro;
    private String commentYN;
    private String scoreYN;
    private String continueYN;
    private String rankYN;
    private String bMusicYN;
    private String eMusicYN;
    private int quizIdx;
    private LocalDateTime regDate;
}
