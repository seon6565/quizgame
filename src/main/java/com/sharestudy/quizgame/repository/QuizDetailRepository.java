package com.sharestudy.quizgame.repository;

import com.sharestudy.quizgame.domain.QuizDetailEntity;
import com.sharestudy.quizgame.domain.QuizMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizDetailRepository extends JpaRepository<QuizDetailEntity, Integer> {
    List<QuizDetailEntity> findAllByQuizIdx(int quizIdx);
}
