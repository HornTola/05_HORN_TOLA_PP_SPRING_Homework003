package org.example.springhomework003.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventAttendeeRepository {
    @Insert("INSERT INTO event_attendee (event_id, attendee_id) VALUES (#{eventId}, #{attendeeId})")
    void saveEventAttendee(@Param("eventId") Integer eventId, @Param("attendeeId") Integer attendeeId);
}
