package org.example.springhomework003.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springhomework003.model.Attendee;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    String attendeeName;
    String email;
}
