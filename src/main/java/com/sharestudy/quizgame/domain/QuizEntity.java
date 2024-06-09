package com.sharestudy.quizgame.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="tiki_quiz")
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int quizIdx;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 300, nullable = false)
    private  String thumbnail;
    @Column(length = 200, nullable = false)
    private String keyword;
    @Column(length = 200, nullable = false)
    private String school;
    @Column(length = 200, nullable = false)
    private String geade;
    @Column(length = 200, nullable = false)
    private String semster;
    @Column(length = 200, nullable = false)
    private String chapter;
    @Column(length = 200, nullable = false)
    private String chaxi;
    @Column(length = 200, nullable = false)
    private String orgfile;
    @Column(length = 200, nullable = false)
    private String savefile;
    @Column(length = 10, nullable = false)
    private LocalDate regDate;
    @Column(length = 2, nullable = false)
    private String status;
    @Column(length = 100, nullable = false)
    private String share;
    @Column(length = 11, nullable = false)
    private int memberIdx;
}