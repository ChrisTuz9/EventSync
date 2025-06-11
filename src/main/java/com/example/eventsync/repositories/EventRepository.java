package com.example.eventsync.repositories;

import com.example.eventsync.model.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EventRepository {

    @Insert("""
            INSERT INTO events (id, title, description)
            VALUES (#{id}, #{title}, #{description})
            """)
    void insertEvent(Event event);
}
