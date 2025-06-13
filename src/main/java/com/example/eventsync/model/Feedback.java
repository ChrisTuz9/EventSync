package com.example.eventsync.model;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class Feedback {
    private UUID id;
    private UUID eventId;
    private String message;
    private Instant createdAt;
    private SentimentType sentiment;
}
