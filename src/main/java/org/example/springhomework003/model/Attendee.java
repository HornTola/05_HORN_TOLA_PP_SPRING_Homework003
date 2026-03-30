package org.example.springhomework003.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {
    Integer attendeeId;
    String attendeeName;
    String email;
}
