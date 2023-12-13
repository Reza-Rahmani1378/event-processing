package com.rezarahmani.eventprocessing.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezarahmani.eventprocessing.model.ClickEvent;
import com.rezarahmani.eventprocessing.model.ImpressionEvent;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uk.co.jemos.podam.api.PodamFactory;

@Service
@RequiredArgsConstructor
@Log4j2
public class MessageProducer {

    private final KafkaMessageSender messageSender;
    private final ObjectMapper objectMapper;
    private final PodamFactory factory;

    @Value(value = "${kafka.topic.impression.name}")
    private String impressionTopic;

    @Value(value = "${kafka.topic.click.name}")
    private String clickTopic;

    @SneakyThrows
    @Scheduled(cron ="${message.producer.fixed.rate.value}")
    public void messageProducer() {

        ImpressionEvent impressionEvent = getImpressionEventModel();
        messageSender.sendAdvertisingMessage(impressionTopic,
                writeObjectAsString(impressionEvent));
        log.info("Message with topic {} send.", impressionTopic);

        Thread.sleep(5000);

        messageSender.sendAdvertisingMessage(clickTopic,
                writeObjectAsString(getClickEventModel(impressionEvent.getRequestId())));
        log.info("Message with topic {} send.", clickTopic);
    }


    private ImpressionEvent getImpressionEventModel() {

        return factory.manufacturePojo(ImpressionEvent.class);
    }


    private ClickEvent getClickEventModel(String requestId) {
        ClickEvent model = factory.manufacturePojo(ClickEvent.class);
        model.setRequestId(requestId);
        return model;
    }

    @SneakyThrows
    private String writeObjectAsString(Object var) {
        return objectMapper.writeValueAsString(var
        );
    }

}
