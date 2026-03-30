package org.example.springhomework003.service.impl;

import org.example.springhomework003.model.Attendee;
import org.example.springhomework003.model.request.AttendeeRequest;
import org.example.springhomework003.repository.AttendeeRepository;
import org.example.springhomework003.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAllAttendee() {
        return attendeeRepository.getAllAttendee();
    }

    @Override
    public Attendee getAttendeeById(Integer attendeeId) {
        return attendeeRepository.findAttendeeById(attendeeId);
    }

    @Override
    public Attendee createAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.saveAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendeeById(Integer attendeeId, AttendeeRequest attendeeRequest) {
        return attendeeRepository.updateAttendeeById(attendeeId, attendeeRequest);
    }

    @Override
    public void deleteAttendeeById(Integer attendeeId) {
        attendeeRepository.deleteAttendeeById(attendeeId);
    }
}
