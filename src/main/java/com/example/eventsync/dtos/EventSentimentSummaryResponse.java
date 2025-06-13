package com.example.eventsync.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventSentimentSummaryResponse {
    private int positiveCount;
    private int neutralCount;
    private int negativeCount;
}
