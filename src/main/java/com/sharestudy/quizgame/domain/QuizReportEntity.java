package com.sharestudy.quizgame.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tiki_report")
public class QuizReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int reportIdx;
    @Column(length = 11, nullable = false)
    private int roomIdx;
    @Column(length = 20, nullable = false)
    private String sName;
    @Column(length = 500, nullable = false)
    private String sQuestion;
    @Column(length = 200, nullable = false)
    private String sAnswer;
    @Column(length = 1, nullable = false)
    private String sAnswerYN;
    @Column(length = 3, nullable = false)
    private int sScore;
    @CreatedDate
    @Column(name="reg_date", updatable = false)
    private LocalDateTime regDate;
}
