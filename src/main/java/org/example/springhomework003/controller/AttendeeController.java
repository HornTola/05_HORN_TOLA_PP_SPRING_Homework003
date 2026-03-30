package org.example.springhomework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

import org.example.springhomework003.model.Attendee;
import org.example.springhomework003.model.request.AttendeeRequest;
import org.example.springhomework003.model.response.ApiResponse;
import org.example.springhomework003.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {
    private final AttendeeService attendeeService;

    @Operation(summary = "Get All Attendee")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendee() {
        List<Attendee> instructors = attendeeService.getAllAttendee();
        ApiResponse<List<Attendee>> response = new ApiResponse<>(
                LocalDateTime.now(),
                "Get Attendee Successfully",
                HttpStatus.OK,
                instructors
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get Attendee by id")
    @GetMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<Attendee>> getAttendeeById(@PathVariable Integer attendeeId) {

        if (attendeeService.getAttendeeById(attendeeId) != null) {
            ApiResponse response = ApiResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message("Get Attendee By ID " + attendeeId + " Successfully")
                    .status(HttpStatus.OK)
                    .payload(attendeeService.getAttendeeById(attendeeId))
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new Attendee")
    @PostMapping
    public ResponseEntity<ApiResponse<Attendee>> createAttendeeById(@RequestBody AttendeeRequest attendeeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Attendee>builder()
                .timestamp(LocalDateTime.now())
                .message("Create Attendee Successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.createAttendee(attendeeRequest))
                .build());
    }

    @Operation(summary = "Update Attendee by id")
    @PutMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<Attendee>> updateAttendeeById(@PathVariable Integer attendeeId,
                                                                    @RequestBody AttendeeRequest attendeeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Attendee>builder()
                .timestamp(LocalDateTime.now())
                .message("Update Attendee By ID Successfully")
                .status(HttpStatus.OK)
                .payload(attendeeService.updateAttendeeById(attendeeId, attendeeRequest))
                .build());
    }

    @Operation(summary = "Delete Attendee by ID")
    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendeeById(@PathVariable Integer attendeeId) {
        attendeeService.deleteAttendeeById(attendeeId);

        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .message("Delete Instructor By ID " + attendeeId + " Successfully")
                .status(HttpStatus.OK)
                .build());
    }
}
