package com.example.eventsync.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Event {
    private UUID id;
    private String title;
    private String description;
}
