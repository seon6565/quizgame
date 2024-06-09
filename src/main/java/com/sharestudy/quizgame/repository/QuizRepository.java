package com.sharestudy.quizgame.repository;

import com.sharestudy.quizgame.domain.QuizEntity;
import com.sharestudy.quizgame.domain.QuizMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, Integer> {
}
