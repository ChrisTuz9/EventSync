package com.example.eventsync.dtos;

import lombok.Data;

@Data
public class SentimentCount {
    private String sentiment;
    private Integer count;
}
