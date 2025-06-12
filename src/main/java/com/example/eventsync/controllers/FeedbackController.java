package com.example.eventsync.controllers;

import com.example.eventsync.dtos.CreateFeedbackRequest;
import com.example.eventsync.dtos.FeedbackResponse;
import com.example.eventsync.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("events/{eventId}/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedbackResponse submitFeedback(
            @PathVariable UUID eventId,
            @RequestBody CreateFeedbackRequest request
    ) {
        return feedbackService.createFeedback(eventId, request);
    }
}
