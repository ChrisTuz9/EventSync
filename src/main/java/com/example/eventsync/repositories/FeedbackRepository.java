package com.example.eventsync.repositories;

import com.example.eventsync.model.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FeedbackRepository {
    @Insert("""
            INSERT INTO feedbacks (id, event_id, message, created_at, sentiment)
            VALUES (#{id}, #{eventId}, #{message}, #{createdAt}, #{sentiment})
            """)
    void insertFeedback(Feedback feedback);
}
