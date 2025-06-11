package com.example.eventsync.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Event {
    private UUID id;
    private String title;
    private String description;
}
