package org.example.springhomework003.controller;

import com.sun.jdi.request.EventRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.Event;
import org.example.springhomework003.model.response.ApiResponse;
import org.example.springhomework003.repository.EventAttendeeRepository;
import org.example.springhomework003.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @Operation(summary = "Get All Event")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(ApiResponse.<List<Event>>builder()
                .timestamp(LocalDateTime.now())
                .message("Retrieved events successfully")
                .status(HttpStatus.OK)
                .payload(events)
                .build());
    }

    @Operation(summary = "Get Event by ID")
    @GetMapping("/{eventId}")
    public ResponseEntity<ApiResponse<Event>> getStudentById(@PathVariable Integer eventId){

        if (eventService.getEventById(eventId) != null) {
            ApiResponse response = ApiResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message("Get Student By ID " + eventId + " Successfully")
                    .status(HttpStatus.OK)
                    .payload(eventService.getEventById(eventId))
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.notFound().build();
    }

//    @Operation(summary = "Create New Event")
//    @PostMapping
//    public ResponseEntity<ApiResponse<Event>> createEvent(@RequestBody EventRequest request) {
//        Event event = eventService.createEvent(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                ApiResponse.<Event>builder()
//                        .message("Event created successfully")
//                        .status(HttpStatus.CREATED)
//                        .payload(event).build()
//        );
//    }

    @Operation(summary = "Update Event by ID")
    @PutMapping("/{eventId}")
    public ResponseEntity<ApiResponse<Event>> updateEvent(@PathVariable Integer id, @RequestBody EventRequest request) {
        Event event = eventService.updateEvent(id, request);
        return ResponseEntity.ok(ApiResponse.<Event>builder()
                .message("Event updated successfully")
                .status(HttpStatus.OK)
                .payload(event).build());
    }

    @Operation(summary = "Delete Event by ID")
    @DeleteMapping("/{eventId}")
    public ResponseEntity<ApiResponse<Void>> deleteEvent(@PathVariable Integer id) {
        eventService.deleteEventById(id);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Event deleted successfully")
                .status(HttpStatus.OK).build());
    }
}
