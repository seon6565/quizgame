package com.sharestudy.quizgame.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharestudy.quizgame.dto.QuizMemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumer {
    private final SimpMessagingTemplate template;
    private final ObjectMapper objectMapper;
    @KafkaListener(groupId = "my-consumer-group" ,topics="quizgame")
    public void listenChat(QuizMemberDTO quizMemberDTO){
        log.info("Received message: {}", quizMemberDTO);

        try {
            log.info("quizMemberDTO : " + quizMemberDTO);
            log.info("quizMemberDTO objectMapper : " + objectMapper.writeValueAsString(quizMemberDTO));
            template.convertAndSend("/sub/quizgame/" + quizMemberDTO.getRoomIdx(), objectMapper.writeValueAsString(quizMemberDTO));
            log.info("Message sent to WebSocket");
        } catch (Exception e) {
            log.error("Error sending message to WebSocket", e);
        }
    }
}
