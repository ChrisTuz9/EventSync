package com.example.eventsync.controllers;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.EventResponse;
import com.example.eventsync.dtos.EventSentimentSummaryResponse;
import com.example.eventsync.dtos.SentimentResponse;
import com.example.eventsync.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse createEvent(@RequestBody CreateEventRequest event) {
        return eventService.createEvent(event);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}/summary")
    @ResponseStatus(HttpStatus.OK)
    public EventSentimentSummaryResponse getEventSentimentSummary(@PathVariable UUID eventId) {
        return eventService.getSentimentSummary(eventId);
    }
}
