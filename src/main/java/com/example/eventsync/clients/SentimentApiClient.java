package com.example.eventsync.clients;

import com.example.eventsync.dtos.SentimentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SentimentApiClient {
    @Value("${huggingface.api.url}")
    private String huggingFaceUrl;

    @Value("${huggingface.api.token}")
    private String huggingFaceToken;

    private final RestTemplate restTemplate;

    public SentimentResponse[][] analyzeMessage(String message) {
        HttpEntity<Map<String, String>> request = buildHttpRequest(message);

        try{
            ResponseEntity<SentimentResponse[][]> response = restTemplate.postForEntity(
                    huggingFaceUrl,
                    request,
                    SentimentResponse[][].class
            );

            if(response.getStatusCode().is2xxSuccessful()){
                return response.getBody();
            } else {
                throw new RuntimeException("Sentiment API returned status: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to call sentiment API", e);
        }
    }

    private HttpEntity<Map<String, String>> buildHttpRequest(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(huggingFaceToken);

        Map<String, String> body = Collections.singletonMap("inputs", message);
        return new HttpEntity<>(body, headers);
    }
}
