package org.example.springhomework003.service;

import org.example.springhomework003.model.Attendee;
import org.example.springhomework003.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {

    List<Attendee> getAllAttendee();

    Attendee getAttendeeById(Integer attendeeId);

    Attendee createAttendee(AttendeeRequest attendeeRequest);

    Attendee updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest);

    void deleteAttendeeById(Integer attendeeId);
}
