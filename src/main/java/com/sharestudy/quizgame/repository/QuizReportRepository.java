package com.sharestudy.quizgame.repository;

import com.sharestudy.quizgame.domain.QuizReportEntity;
import com.sharestudy.quizgame.domain.QuizRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizReportRepository extends JpaRepository<QuizReportEntity, Integer> {
}
