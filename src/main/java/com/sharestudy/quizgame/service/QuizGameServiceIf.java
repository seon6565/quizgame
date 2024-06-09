package com.sharestudy.quizgame.service;

import com.sharestudy.quizgame.dto.*;

import java.util.List;

public interface QuizGameServiceIf {
    public QuizRoomDTO createRoom(QuizRoomDTO quizRoomDTO);
    public QuizReportDTO saveReport(QuizReportDTO quizReportDTO);
    public QuizMemberDTO saveQuizMember(QuizMemberDTO quizMemberDTO);

    public QuizDTO readQuiz(QuizDTO quizDTO);
    public List<QuizDetailDTO> readQuizDetailList(QuizDTO quizDTO);
}
