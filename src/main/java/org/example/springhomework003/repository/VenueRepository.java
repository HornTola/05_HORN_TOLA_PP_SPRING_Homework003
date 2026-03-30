package org.example.springhomework003.repository;

import org.apache.ibatis.annotations.*;
import org.example.springhomework003.model.Venue;
import org.example.springhomework003.model.request.VenueRequest;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("SELECT * FROM venues")
    @Results(id = "venueMapping", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
            @Result(property = "location", column = "location")
    })
    List<Venue> getAllVenue();

    @Select("""
            SELECT * FROM venues
            WHERE venue_id = #{venueId}
            """)
    @ResultMap("venueMapping")
    Venue findVenueById(Integer venueId);


    @Select("""
    INSERT INTO venues (venue_name, location) 
    VALUES (#{req.venueName}, #{req.location})
    RETURNING *
    """)
    @ResultMap("venueMapping")
    Venue saveVenue(@Param("req") VenueRequest venueRequest);

    @Select("""
            UPDATE venues 
            SET venue_name = #{req.venueName}, location = #{req.location} 
            WHERE venue_id = #{id}
            """)
    @ResultMap("venueMapping")
    Venue updateVenueById(@Param("id") Integer venueId, @Param("req") VenueRequest venueRequest);

    @Delete("DELETE FROM Venues WHERE venue_id = #{id}")
    void deleteVenueById(@Param("id") Integer venueId);
}
