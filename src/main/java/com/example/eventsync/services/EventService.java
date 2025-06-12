package com.example.eventsync.services;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.EventResponse;
import com.example.eventsync.mapper.EventMapper;
import com.example.eventsync.model.Event;
import com.example.eventsync.repositories.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public EventResponse createEvent(CreateEventRequest request) {
        Event event = EventMapper.fromDto(request);
        eventRepository.insertEvent(event);
        return EventMapper.toDto(event);
    }

    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.selectAllEvents();
        return EventMapper.toDtoList(events);
    }
}
