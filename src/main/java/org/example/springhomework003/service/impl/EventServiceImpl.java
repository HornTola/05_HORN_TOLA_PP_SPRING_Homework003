package org.example.springhomework003.service.impl;

import com.sun.jdi.request.EventRequest;
import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.Event;
import org.example.springhomework003.repository.EventAttendeeRepository;
import org.example.springhomework003.repository.EventRepository;
import org.example.springhomework003.service.EventService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventAttendeeRepository eventAttendeeRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.getAllEvents();
    }

//    @Override
//    @Transactional
//    public Event createEvent(EventRequest request) {
//        Event event = eventRepository.createEvent(request);
//
//        if (request.getAttendeeId() != null) {
//            for (Integer attendeeId : request.getAttendeeId()) {
//                eventAttendeeRepository.saveEventAttendee(event.getEventId(), attendeeId);
//            }
//        }
//
//        return eventRepository.getEventById(event.getEventId());
//    }

    @Override
    public Event updateEvent(Integer id, EventRequest request) {
        return null;
    }

    @Override
    @Transactional
    public void deleteEventById(Integer id) {
        eventRepository.deleteEventById(id);
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventRepository.GetEventById(eventId);
    }
}