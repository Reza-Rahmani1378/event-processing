package com.rezarahmani.eventprocessing.service;

import com.rezarahmani.eventprocessing.model.AddEvent;
import com.rezarahmani.eventprocessing.repository.AddEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddEventServiceImpl implements AddEventService {

    private final AddEventRepository repository;

    @Override
    public AddEvent saveAddEvent(AddEvent event) {
        /*repository.findById(event.getRequestId()).ifPresentOrElse(
                existedEvent -> {
                    existedEvent.setClickTime(event.getClickTime());
                    repository.save(existedEvent);
                },
                () -> repository.save(event)
        );*/

        var existedEvent = repository.findById(event.getRequestId());
        if (existedEvent.isPresent()) {
            var addEvent = existedEvent.get();
            addEvent.setClickTime(event.getClickTime());
            return repository.save(addEvent);
        }
        return repository.save(event);
    }

}
