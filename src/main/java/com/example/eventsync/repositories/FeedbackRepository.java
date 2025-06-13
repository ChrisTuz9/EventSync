package com.example.eventsync.repositories;

import com.example.eventsync.model.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
@Mapper
public interface FeedbackRepository {
    @Insert("""
            INSERT INTO feedbacks (id, event_id, message, created_at, sentiment)
            VALUES (#{id}, #{eventId}, #{message}, #{createdAt}, #{sentiment})
            """)
    void insertFeedback(Feedback feedback);

    @Select("""
            SELECT sentiment, COUNT (*)
            FROM feedbacks
            WHERE event_id = #{eventId}
            GROUP BY sentiment
            """)
    @MapKey("sentiment")
    Map<String, Integer> countSentimentsByEventId(UUID eventId);
}
