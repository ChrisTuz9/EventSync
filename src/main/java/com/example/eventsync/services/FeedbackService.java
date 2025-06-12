package com.example.eventsync.services;

import com.example.eventsync.dtos.CreateFeedbackRequest;
import com.example.eventsync.dtos.FeedbackResponse;
import com.example.eventsync.mapper.FeedbackMapper;
import com.example.eventsync.model.Event;
import com.example.eventsync.model.Feedback;
import com.example.eventsync.repositories.EventRepository;
import com.example.eventsync.repositories.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final EventRepository eventRepository;

    public FeedbackResponse createFeedback(UUID eventId, CreateFeedbackRequest request) {
        Event event = eventRepository.findById(eventId);
        if(event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        Feedback feedback = FeedbackMapper.fromDto(request, eventId);
        feedbackRepository.insertFeedback(feedback);
        return FeedbackMapper.toDto(feedback);
    }
}
