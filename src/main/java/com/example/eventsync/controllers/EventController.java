package com.example.eventsync.controllers;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.CreateEventResponse;
import com.example.eventsync.services.EventService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEventResponse createEvent(@RequestBody CreateEventRequest event) {
        return eventService.createEvent(event);
    }
}
