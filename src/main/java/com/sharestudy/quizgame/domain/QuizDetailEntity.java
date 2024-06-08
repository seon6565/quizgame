package com.sharestudy.quizgame.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tiki_quizdeatil")
public class QuizDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = true)
    private int detailIdx;
    @Column(length = 500, nullable = false)
    private String category;
    @Column(length = 500, nullable = false)
    private int order;
    @Column(length = 500)
    private int timer;
    @Column(length = 500,nullable = false)
    private int score;
    @Column(length = 500, nullable = false)
    private String question;
    @Column(length = 500)
    private String comment;
    @Column(length = 500, nullable = false)
    private String answer;
    @Column(length = 500, nullable = false)
    private int quizIdx;
}