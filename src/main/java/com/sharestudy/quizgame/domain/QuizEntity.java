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
    @Column(unique = true, nullable = true)
    private int quizIdx;
    @Column(length = 500, nullable = false)
    private String title;
    @Column(length = 500, nullable = false)
    private  String thumbnail;
    @Column(length = 500, nullable = false)
    private String keyword;
    @Column(length = 500, nullable = false)
    private String school;
    @Column(length = 500, nullable = false)
    private String geade;
    @Column(length = 500, nullable = false)
    private String semster;
    @Column(length = 500, nullable = false)
    private String chapter;
    @Column(length = 500, nullable = false)
    private String chaxi;
    @Column(length = 500, nullable = false)
    private String orgfile;
    @Column(length = 500, nullable = false)
    private String savefile;
    @Column(length = 10, nullable = false)
    private LocalDate regDate;
    @Column(length = 500, nullable = false)
    private char status;
    @Column(length = 500, nullable = false)
    private String share;
    @Column(length = 500, nullable = false)
    private int memberIdx;
}