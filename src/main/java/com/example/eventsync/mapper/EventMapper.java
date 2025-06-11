package com.example.eventsync.mapper;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.CreateEventResponse;
import com.example.eventsync.model.Event;

import java.util.UUID;

public class EventMapper {
    public static Event fromDto(CreateEventRequest request) {
        return Event.builder()
                .id(UUID.randomUUID())
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
    }

    public static CreateEventResponse toDto(Event event) {
        return CreateEventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .build();
    }
}
