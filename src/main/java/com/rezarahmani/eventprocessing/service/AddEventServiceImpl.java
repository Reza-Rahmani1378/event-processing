package com.rezarahmani.eventprocessing.service;

import com.rezarahmani.eventprocessing.model.AddEvent;
import com.rezarahmani.eventprocessing.repository.AddEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddEventServiceImpl implements AddEventService {

    private final AddEventRepository repository;

    @Override
    public void saveAddEvent(AddEvent event) {
        repository.findById(event.getRequestId()).ifPresentOrElse(
                existedEvent -> {
                    existedEvent.setClickTime(event.getClickTime());
                    repository.save(existedEvent);
                },
                () -> repository.save(event)
        );
    }

}
