package com.rezarahmani.eventprocessing.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezarahmani.eventprocessing.model.ImpressionEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {

    private final KafkaMessageSender messageSender;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.topic.impression.name}")
    private String impressionTopic;

    @Value(value = "${kafka.topic.click.name}")
    private String clickTopic;

    @SneakyThrows
    @Scheduled(cron ="${message.producer.fixed.rate.value}")
    public void messageProducer() {
        messageSender.sendImpressingMessage(impressionTopic,objectMapper.writeValueAsString(new ImpressionEvent()));
        System.out.println("Message Send.");
        Thread.sleep(5000);
    }

}
