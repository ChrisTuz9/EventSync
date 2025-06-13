package com.example.eventsync.services;

import com.example.eventsync.clients.SentimentApiClient;
import com.example.eventsync.dtos.CreateFeedbackRequest;
import com.example.eventsync.dtos.FeedbackResponse;
import com.example.eventsync.dtos.SentimentResponse;
import com.example.eventsync.mapper.FeedbackMapper;
import com.example.eventsync.model.Event;
import com.example.eventsync.model.Feedback;
import com.example.eventsync.model.SentimentType;
import com.example.eventsync.repositories.EventRepository;
import com.example.eventsync.repositories.FeedbackRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final EventRepository eventRepository;
    private final SentimentApiClient sentimentApiClient;

    public FeedbackResponse createFeedback(UUID eventId, CreateFeedbackRequest request) {
        Event event = eventRepository.findById(eventId);
        if(event == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }

        SentimentResponse[] sentimentResponses = sentimentApiClient.analyzeMessage(request.getMessage())[0];

        SentimentResponse topSentiment = Arrays.stream(sentimentResponses)
                .max((a, b) -> Double.compare(a.getScore(), b.getScore()))
                .orElseThrow(() -> new RuntimeException("No sentiment result returned."));

        SentimentType sentimentType = mapLabelToSentimentType(topSentiment.getLabel());

        Feedback feedback = FeedbackMapper.fromDto(request, eventId);
        feedbackRepository.insertFeedback(feedback);
        return FeedbackMapper.toDto(feedback);
    }

    private SentimentType mapLabelToSentimentType(String label) {
        return switch(label) {
            case "LABEL_0" -> SentimentType.NEGATIVE;
            case "LABEL_1" -> SentimentType.NEUTRAL;
            case "LABEL_2" -> SentimentType.POSITIVE;
            default -> throw new RuntimeException("Unknown sentiment label: " + label);
        };
    }
}
