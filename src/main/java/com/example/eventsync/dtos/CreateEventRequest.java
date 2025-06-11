package com.example.eventsync.dtos;

import lombok.Data;

@Data
public class CreateEventRequest {
    private String title;
    private String description;
}
