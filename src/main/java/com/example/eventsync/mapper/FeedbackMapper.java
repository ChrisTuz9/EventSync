package com.example.eventsync.mapper;

import com.example.eventsync.dtos.CreateFeedbackRequest;
import com.example.eventsync.dtos.FeedbackResponse;
import com.example.eventsync.model.Feedback;
import com.example.eventsync.model.SentimentType;

import java.time.Instant;
import java.util.UUID;

public class FeedbackMapper {
    public static Feedback fromDto(CreateFeedbackRequest request, UUID eventId, SentimentType sentimentType) {
        return Feedback.builder()
                .id(UUID.randomUUID())
                .eventId(eventId)
                .message(request.getMessage())
                .createdAt(Instant.now())
                .sentiment(sentimentType)
                .build();
    }

    public static FeedbackResponse toDto(Feedback feedback) {
        return FeedbackResponse.builder()
                .id(feedback.getId())
                .eventId(feedback.getEventId())
                .message(feedback.getMessage())
                .createdAt(feedback.getCreatedAt())
                .sentiment(feedback.getSentiment())
                .build();
    }
}
