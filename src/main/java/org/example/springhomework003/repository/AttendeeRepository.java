package org.example.springhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.Attendee;
import org.example.springhomework003.model.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {


    @Select("SELECT * FROM attendees")
    @Results(id = "attendeeMapping", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    List<Attendee> getAllAttendee();

    @Select("""
            SELECT * FROM attendees
            WHERE attendee_id = #{id}
            """)
    @ResultMap("attendeeMapping")
    Attendee findAttendeeById(@Param("id") Integer attendeeId);

    @Select("""
            INSERT INTO attendees (attendee_name, email)
            VALUES (#{req.attendeeName}, #{req.email})
            RETURNING *
            """)
    @ResultMap("attendeeMapping")
    Attendee saveAttendee(@Param("req") AttendeeRequest attendeeRequest);

    @Select("""
            UPDATE attendees
            SET attendee_name = #{req.attendeeName}, email = #{req.email}
            WHERE attendee_id = #{id}
            RETURNING *
            """)
    @ResultMap("attendeeMapping")
    Attendee updateAttendeeById(@Param("id") Integer attendeeId, @Param("req") AttendeeRequest attendeeRequest);

    @Delete("DELETE FROM attendees WHERE attendee_id = #{id}")
    void deleteAttendeeById(@Param("id") Integer attendeeId);
}
