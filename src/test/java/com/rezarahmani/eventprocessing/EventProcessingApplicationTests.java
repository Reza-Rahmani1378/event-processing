package com.rezarahmani.eventprocessing;

import com.rezarahmani.eventprocessing.model.AddEvent;
import com.rezarahmani.eventprocessing.repository.AddEventRepository;
import com.rezarahmani.eventprocessing.service.AddEventService;
import com.rezarahmani.eventprocessing.service.AddEventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventProcessingApplicationTests {
   private AddEventRepository addEventRepository;
   private AddEventService addEventService;

   @BeforeEach
   void initialObjects() {
       addEventRepository = mock(AddEventRepository.class);
       addEventService = new AddEventServiceImpl(addEventRepository);
   }

    @Test
    void testSaveEvent() {
        var addEvent = getAddEventEntity();
        when(addEventRepository.save(addEvent)).thenReturn(addEvent);
        when(addEventRepository.findById(addEvent.getRequestId())).thenReturn(Optional.empty());
        var savedEvent = addEventService.saveAddEvent(addEvent);
        assertThat(savedEvent.getRequestId()).isEqualTo(addEvent.getRequestId());
        assertThat(savedEvent.getAddTitle()).isEqualTo(addEvent.getAddTitle());
        assertThat(savedEvent.getAppTitle()).isEqualTo(addEvent.getAppTitle());
        assertThat(savedEvent.getAppId()).isEqualTo(addEvent.getAppId());
        assertThat(savedEvent.getAdId()).isEqualTo(addEvent.getAdId());
        assertThat(savedEvent.getImpressionTime()).isEqualTo(addEvent.getImpressionTime());
        assertThat(savedEvent.getClickTime()).isNull();
    }


    @Test
    public void testUpdateEvent() {
        var updatedEventEntity = getUpdatedEventEntity();
        when(addEventRepository.save(updatedEventEntity)).thenReturn(updatedEventEntity);
        when(addEventRepository.findById(updatedEventEntity.getRequestId())).thenReturn(Optional.of(updatedEventEntity));
        var savedEvent = addEventService.saveAddEvent(updatedEventEntity);
        assertThat(savedEvent.getRequestId()).isEqualTo("cdaa8638-a6de-4e87-860d-1b3514720ec4");
        assertThat(savedEvent.getAddTitle()).isEqualTo(updatedEventEntity.getAddTitle());
        assertThat(savedEvent.getAppTitle()).isEqualTo(updatedEventEntity.getAppTitle());
        assertThat(savedEvent.getAppId()).isEqualTo(updatedEventEntity.getAppId());
        assertThat(savedEvent.getAdId()).isEqualTo(updatedEventEntity.getAdId());
        assertThat(savedEvent.getImpressionTime()).isEqualTo(updatedEventEntity.getImpressionTime());
        assertThat(savedEvent.getClickTime()).isNotNull();
    }


    private AddEvent getAddEventEntity() {
        return AddEvent.builder()
                .requestId(UUID.randomUUID().toString())
                .addTitle("Ev1")
                .appTitle("tapsel")
                .appId("10")
                .adId("hf39uj")
                .impressionTime(new Date().getTime())
                .build();
    }

    private AddEvent getUpdatedEventEntity() {
        return AddEvent.builder()
                .addTitle("Ev1")
                .appTitle("tapsel")
                .appId("10")
                .adId("hf39uj")
                .impressionTime(new Date().getTime())
                .requestId("cdaa8638-a6de-4e87-860d-1b3514720ec4")
                .clickTime(new Date().getTime())
                .build();
    }


}
