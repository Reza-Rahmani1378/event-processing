package com.rezarahmani.eventprocessing.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageConsumer {

    @Value(value = "${kafka.topic.impression.name}")
    private String impressionTopic;

    @Value(value = "${kafka.topic.click.name}")
    private String clickTopic;

    @KafkaListener(topics = "${kafka.topic.impression.name}", groupId = "${kafka.consumer.group.id}")
    public void impressionEventConsumer(String impressionEvent) {
        log.info("Message received {}", impressionEvent);

    }

    @KafkaListener(topics = "${kafka.topic.click.name}", groupId = "${kafka.consumer.group.id}")
    public void clickEventConsumer(String impressionEvent) {
        log.info("Message received {}", impressionEvent);

    }


}
