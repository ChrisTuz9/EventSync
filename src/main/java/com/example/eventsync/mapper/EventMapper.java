package com.example.eventsync.mapper;

import com.example.eventsync.dtos.CreateEventRequest;
import com.example.eventsync.dtos.EventResponse;
import com.example.eventsync.dtos.EventSentimentSummaryResponse;
import com.example.eventsync.dtos.SentimentCount;
import com.example.eventsync.model.Event;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public static EventSentimentSummaryResponse toSentimentSummary(List<SentimentCount> counts) {
        Map<String, Integer> sentimentsCount = counts.stream()
                .collect(Collectors.toMap(SentimentCount::getSentiment, SentimentCount::getCount));

        return EventSentimentSummaryResponse.builder()
                .positiveCount(sentimentsCount.getOrDefault("POSITIVE", 0))
                .neutralCount(sentimentsCount.getOrDefault("NEUTRAL", 0))
                .negativeCount(sentimentsCount.getOrDefault("NEGATIVE", 0))
                .build();
    }
}
