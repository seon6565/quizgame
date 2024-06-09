package com.sharestudy.quizgame.repository;

import com.sharestudy.quizgame.domain.QuizMemberEntity;
import com.sharestudy.quizgame.domain.QuizReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizMemberRepository extends JpaRepository<QuizMemberEntity, Integer> {
}
