package com.sharestudy.quizgame.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tiki_room")
public class QuizRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int roomIdx;
    @Column(length = 11, nullable = true)
    private int teacherIdx;
    @Column(length = 20, nullable = true)
    private String teacherName;
    @Column(length = 200, nullable = true)
    private String title;
    @Column(length = 500, nullable = true)
    private String intro;
    @Column(length = 1, nullable = true)
    private String commentYN;
    @Column(length = 1, nullable = true)
    private String scoreYN;
    @Column(length = 1, nullable = true)
    private String continueYN;
    @Column(length = 1, nullable = true)
    private String rankYN;
    @Column(length = 1, nullable = true)
    private String bMusicYN;
    @Column(length = 1, nullable = true)
    private String eMusicYN;
    @Column(length = 11, nullable = false)
    private int quizIdx;
    @CreatedDate
    @Column(name="reg_date", updatable = false)
    private LocalDateTime regDate;
}
