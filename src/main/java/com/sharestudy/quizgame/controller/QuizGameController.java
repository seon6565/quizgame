package com.sharestudy.quizgame.controller;

import com.sharestudy.quizgame.dto.QuizMemberDTO;
import com.sharestudy.quizgame.service.KafkaProducer;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Log4j2
@AllArgsConstructor
public class QuizGameController {
    private final KafkaProducer producer;

    @MessageMapping("quizgame")
    public void sendSocketMessage(QuizMemberDTO quizMemberDTO) {
        log.info("quizMemberDTO controller : "+ quizMemberDTO);
        producer.sendMessage(quizMemberDTO);

    }
}
