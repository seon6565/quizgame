package com.sharestudy.quizgame.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tiki_quizdetail")
public class QuizDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int detailIdx;
    @Column(length = 100, nullable = false)
    private String category;
    @Column(length = 11, nullable = false)
    private int questionNumber;
    @Column(length = 11, nullable = false)
    private int timer;
    @Column(length = 11, nullable = false)
    private int score;
    @Column(length = 300, nullable = false)
    private String question;
    @Column(length = 300, nullable = false)
    private String comment;
    @Column(length = 300, nullable = false)
    private String answer;
    @Column(length = 11, nullable = false)
    private int quizIdx;
}