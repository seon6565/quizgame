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
@Table(name="tiki_quizmember")
public class QuizMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int quizMemberIdx;
    @Column(length = 11, nullable = false)
    private int roomIdx;
    @Column(length = 20, nullable = false)
    private String sName;
    @Column(length = 4, nullable = false)
    private String sPassword;
    @Column(length = 200, nullable = false)
    private String sImgUrl;
    @Column(length = 2, nullable = false)
    private int sCorrectCount;
    @Column(length = 2, nullable = false)
    private int sAnswerCount;
    @Column(length = 4, nullable = false)
    private int sTotalScore;
    @CreatedDate
    @Column(name="reg_date", updatable = false)
    private LocalDateTime regDate;
}
