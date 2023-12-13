package com.rezarahmani.eventprocessing.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezarahmani.eventprocessing.model.AddEvent;
import com.rezarahmani.eventprocessing.model.ClickEvent;
import com.rezarahmani.eventprocessing.model.ImpressionEvent;
import com.rezarahmani.eventprocessing.service.AddEventService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageConsumer {

    private final AddEventService addEventService;

    private final ObjectMapper mapper;

    private final ModelMapper modelMapper;

    @SneakyThrows
    @KafkaListener(topics = "${kafka.topic.impression.name}", groupId = "${kafka.consumer.group.id}")
    public void impressionEventConsumer(String message) {
        log.info("Message received {}", message);
        var impressionEvent = mapper.readValue(message, ImpressionEvent.class);
        AddEvent event = modelMapper.map(impressionEvent, AddEvent.class);
        addEventService.saveAddEvent(event);
    }

    @SneakyThrows
    @KafkaListener(topics = "${kafka.topic.click.name}", groupId = "${kafka.consumer.group.id}")
    public void clickEventConsumer(String message) {
        log.info("Message received {}", message);
        var clickEvent = mapper.readValue(message, ClickEvent.class);
        AddEvent event = modelMapper.map(clickEvent, AddEvent.class);
        addEventService.saveAddEvent(event);

    }


}
