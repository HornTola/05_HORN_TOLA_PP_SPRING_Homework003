package org.example.springhomework003.repository;

import com.sun.jdi.request.EventRequest;
import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.Event;
import org.example.springhomework003.model.Attendee;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("SELECT * FROM events")
    @Results(id = "eventMapping", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.example.springhomework003.repository.VenueRepository.findVenueById")),
            @Result(property = "attendees", column = "event_id",
                    many = @Many(select = "findAttendeesByEventId"))
    })
    List<Event> getAllEvents();
    
    @Select("""
            SELECT a.* FROM attendees a
            JOIN event_attendee ea ON a.attendee_id = ea.attendee_id
            WHERE ea.event_id = #{eventId}
            """)
    @ResultMap("org.example.springhomework003.repository.AttendeeRepository.attendeeMapping")
    List<Attendee> findAttendeesByEventId(Integer eventId);

    @Delete("DELETE FROM events WHERE event_id = #{id}")
    void deleteEventById(Integer id);

    @Select("""
    INSERT INTO events (event_name, event_date, venue_id) 
    VALUES (#{req.eventName}, #{req.eventDate}, #{req.venueId})
    RETURNING *
    """)
    @ResultMap("eventMapping")
    Event saveEvent(@Param("req") EventRequest request);

    @Select("""
        INSERT INTO events (event_name, event_date, venue_id) 
        VALUES (#{req.eventName}, #{req.eventDate}, #{req.venueId})
        RETURNING *
        """)
    @ResultMap("eventMapping")
    Event createEvent(@Param("req") EventRequest request);

    @ResultMap("eventMapping")
    @Select("""
        SELECT * FROM events
        WHERE event_id = #{eventId}
        """)
    Event GetEventById(Integer eventId);
}