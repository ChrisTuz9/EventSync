package com.example.eventsync.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateEventResponse {
    private UUID id;
    private String title;
    private String description;
}
