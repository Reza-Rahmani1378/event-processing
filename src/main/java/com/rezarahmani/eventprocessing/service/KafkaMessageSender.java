package com.rezarahmani.eventprocessing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessageSender {


    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendImpressingMessage(String topicName,String message) {
        kafkaTemplate.send(topicName, message);
    }
}
