package com.example.eventsync.repositories;

import com.example.eventsync.model.Feedback;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FeedbackRepository {
    @Insert("""
            INSERT INTO feedbacks (id, eventId, message, created_at)
            VALUES (#{id}, #{eventId}, #{message}, #{createdAt})
            """)
    void insertFeedback(Feedback feedback);
}
