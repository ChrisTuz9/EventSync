package com.example.eventsync.mapper;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.EventResponse;
import com.example.eventsync.model.Event;

import java.util.List;
import java.util.UUID;

public class EventMapper {
    public static Event fromDto(CreateEventRequest request) {
        return Event.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
    }

    public static EventResponse toDto(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .build();
    }

    public static List<EventResponse> toDtoList(List<Event> events) {
        return events.stream()
                .map(EventMapper::toDto)
                .toList();
    }
}
