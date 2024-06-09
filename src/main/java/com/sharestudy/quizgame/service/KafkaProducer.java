package com.sharestudy.quizgame.service;

import com.sharestudy.quizgame.dto.QuizMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "quizgame";
    private final KafkaTemplate<String, QuizMemberDTO> kafkaTemplate;

    public void sendMessage(QuizMemberDTO message) {
        kafkaTemplate.send(TOPIC, message);
        log.info("Produce message: {}", message);
    }

}
