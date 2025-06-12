package com.example.eventsync.dtos;

import com.example.eventsync.model.SentimentType;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class FeedbackResponse {
    private UUID id;
    private UUID eventId;
    private String message;
    private Instant createdAt;
    private SentimentType sentiment;
}
