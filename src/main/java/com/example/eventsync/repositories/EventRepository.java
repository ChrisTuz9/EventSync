package com.example.eventsync.repositories;

import com.example.eventsync.model.Event;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Mapper
public interface EventRepository {

    @Insert("""
            INSERT INTO events (id, title, description)
            VALUES (#{id}, #{title}, #{description})
            """)
    void insertEvent(Event event);

    @Select("""
            SELECT * FROM events
            """)
    List<Event> selectAllEvents();

    @Select("""
            SELECT * FROM events WHERE id = #{id}
            """)
    Event findById(UUID id);
}
