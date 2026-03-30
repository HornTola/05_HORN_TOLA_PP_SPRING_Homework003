package org.example.springhomework003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private Integer eventId;
    private String eventName;
    private LocalDate eventDate;
    private Venue venue;
    private List<Integer> attendeeId;
}
