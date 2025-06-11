package com.example.eventsync.services;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.CreateEventResponse;
import com.example.eventsync.mapper.EventMapper;
import com.example.eventsync.model.Event;
import com.example.eventsync.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public CreateEventResponse createEvent(CreateEventRequest request) {
        Event event = EventMapper.fromDto(request);
        eventRepository.insertEvent(event);
        return EventMapper.toDto(event);
    }
}
