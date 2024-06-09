package com.sharestudy.quizgame.controller;

import com.sharestudy.quizgame.dto.QuizMemberDTO;
import com.sharestudy.quizgame.dto.QuizRoomDTO;
import com.sharestudy.quizgame.service.KafkaProducer;
import com.sharestudy.quizgame.service.QuizGameServiceIf;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@AllArgsConstructor
@RequestMapping(value="/game")
public class QuizGameController {
    private final KafkaProducer producer;
    private final QuizGameServiceIf quizGameServiceIf;

//    @MessageMapping("quizgame")
//    public void sendSocketMessage(QuizMemberDTO quizMemberDTO) {
//        log.info("quizMemberDTO controller : "+ quizMemberDTO);
//        producer.sendMessage(quizMemberDTO);
//    }

    @GetMapping("/create")
    public void createroom(QuizRoomDTO quizRoomDTO, Model model){
        log.info("get quizRoomDTO : " + quizRoomDTO);
        model.addAttribute("quizRoomDTO",quizRoomDTO);
    }
    @ResponseBody
    @PostMapping("/create")
    public String createroomPost(QuizRoomDTO quizRoomDTO){
        log.info("quizRoomDTO : " + quizRoomDTO);
        String roomIdx = String.valueOf(quizGameServiceIf.createRoom(quizRoomDTO).getRoomIdx());
        return roomIdx;
    }
    @GetMapping("/joingame")
    public void joinroom(QuizRoomDTO quizRoomDTO){
    }

    @ResponseBody
    @PostMapping("/joinmember")
    public QuizMemberDTO joinmember(QuizMemberDTO quizMemberDTO){
        log.info("joinmember : " + quizMemberDTO);
        quizGameServiceIf.saveQuizMember(quizMemberDTO);
        producer.sendMessage(quizMemberDTO);
        return quizMemberDTO;
    }
}
