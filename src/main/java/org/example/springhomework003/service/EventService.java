package org.example.springhomework003.service;

import com.sun.jdi.request.EventRequest;
import org.example.springhomework003.model.Event;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface EventService {

    List<Event> getAllEvents();

//    Event createEvent(EventRequest request);

    Event updateEvent(Integer id, EventRequest request);

    void deleteEventById(Integer id);

    Event getEventById(Integer eventId);
}
