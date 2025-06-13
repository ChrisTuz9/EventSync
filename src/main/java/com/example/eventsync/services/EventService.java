package com.example.eventsync.services;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.EventResponse;
import com.example.eventsync.dtos.EventSentimentSummaryResponse;
import com.example.eventsync.mapper.EventMapper;
import com.example.eventsync.model.Event;
import com.example.eventsync.repositories.EventRepository;
import com.example.eventsync.repositories.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final FeedbackRepository feedbackRepository;

    public EventResponse createEvent(CreateEventRequest request) {
        Event event = EventMapper.fromDto(request);
        eventRepository.insertEvent(event);
        return EventMapper.toDto(event);
    }

    public List<EventResponse> getAllEvents() {
        List<Event> events = eventRepository.selectAllEvents();
        return EventMapper.toDtoList(events);
    }

    public EventSentimentSummaryResponse getSentimentSummary(UUID eventId) {
        Event event = eventRepository.findById(eventId);
        if(event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        Map<String, Integer> sentimentsCount = feedbackRepository.countSentimentsByEventId(eventId);

        return EventSentimentSummaryResponse.builder()
                .positiveCount(sentimentsCount.getOrDefault("POSITIVE", 0))
                .neutralCount(sentimentsCount.getOrDefault("NEUTRAL", 0))
                .negativeCount(sentimentsCount.getOrDefault("NEGATIVE", 0))
                .build();
    }
}
