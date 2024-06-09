package com.sharestudy.quizgame.service;

import com.sharestudy.quizgame.domain.QuizEntity;
import com.sharestudy.quizgame.domain.QuizMemberEntity;
import com.sharestudy.quizgame.domain.QuizReportEntity;
import com.sharestudy.quizgame.domain.QuizRoomEntity;
import com.sharestudy.quizgame.dto.*;
import com.sharestudy.quizgame.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@RequiredArgsConstructor
@Service
public class QuizGameServiceImpl implements QuizGameServiceIf {
    private final QuizRepository quizRepository;
    private final QuizDetailRepository quizDetailRepository;
    private final QuizReportRepository quizReportRepository;
    private final QuizRoomRepository quizRoomRepository;
    private final QuizMemberRepository quizMemberRepository;
    private final ModelMapper modelMapper;

    @Override
    public QuizRoomDTO createRoom(QuizRoomDTO quizRoomDTO) {
        QuizRoomEntity quizRoomEntity = modelMapper.map(quizRoomDTO,QuizRoomEntity.class);
        int roomIdx = quizRoomRepository.save(quizRoomEntity).getRoomIdx();
        quizRoomDTO.setRoomIdx(roomIdx);
        log.info("result quizRoomDTO : " + quizRoomDTO );
        return quizRoomDTO;
    }

    @Override
    public QuizReportDTO saveReport(QuizReportDTO quizReportDTO) {
        QuizReportEntity quizReportEntity = modelMapper.map(quizReportDTO,QuizReportEntity.class);
        quizReportRepository.save(quizReportEntity);
        return null;
    }

    @Override
    public QuizMemberDTO saveQuizMember(QuizMemberDTO quizMemberDTO) {
        QuizMemberEntity quizMemberEntity = modelMapper.map(quizMemberDTO,QuizMemberEntity.class);
        quizMemberRepository.save(quizMemberEntity);
        return null;
    }

    @Override
    public QuizDTO readQuiz(QuizDTO quizDTO) {
        Optional<QuizEntity> result = quizRepository.findById(quizDTO.getQuizIdx());
        QuizEntity quizEntity = result.orElse(null);
        if(quizEntity!=null){
            QuizDTO resultDTO = modelMapper.map(quizEntity,QuizDTO.class);
            log.info("quiz resultDTO : "+resultDTO);
            return resultDTO;
        }
        return null;
    }

    @Override
    public List<QuizDetailDTO> readQuizDetailList(QuizDTO quizDTO) {
        return quizDetailRepository.findAllByQuizIdx(quizDTO.getQuizIdx())
                .stream().map(entity->modelMapper.map(entity,QuizDetailDTO.class)).collect(Collectors.toList());
    }
}
