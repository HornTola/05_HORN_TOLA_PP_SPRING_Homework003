package org.example.springhomework003.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.springhomework003.model.request.VenueRequest;
import org.example.springhomework003.model.response.ApiResponse;
import org.example.springhomework003.model.Venue;
import org.example.springhomework003.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @Operation(summary = "Get all venues")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenue() {
        List<Venue> instructors = venueService.getAllVenue();
        ApiResponse<List<Venue>> response = new ApiResponse<>(
                LocalDateTime.now(),
                "Get Instructor Successfully",
                HttpStatus.OK,
                instructors
        );
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get Instructor by id")
    @GetMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable Integer venueId) {

        if (venueService.getVenueById(venueId) != null) {
            ApiResponse response = ApiResponse.builder()
                    .timestamp(LocalDateTime.now())
                    .message("Get Venue By ID " + venueId + " Successfully")
                    .status(HttpStatus.OK)
                    .payload(venueService.getVenueById(venueId))
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new Venue")
    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> createVenue(@RequestBody VenueRequest venueRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Venue>builder()
                .timestamp(LocalDateTime.now())
                .message("Create Instructor Successfully")
                .status(HttpStatus.OK)
                .payload(venueService.saveVenue(venueRequest))
                .build());
    }

    @Operation(summary = "Update Instructor by id")
    @PutMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@PathVariable Integer venueId,
                                                                        @RequestBody VenueRequest venueRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.<Venue>builder()
                .timestamp(LocalDateTime.now())
                .message("Update Venue By ID Successfully")
                .status(HttpStatus.OK)
                .payload(venueService.updateVenueById(venueId, venueRequest))
                .build());
    }

    @Operation(summary = "Delete Instructor by ID")
    @DeleteMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Void>> deleteVenueById(@PathVariable Integer venueId) {
        venueService.deleteVenueById(venueId);

        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .timestamp(LocalDateTime.now())
                .message("Delete Instructor By ID " + venueId + " Successfully")
                .status(HttpStatus.OK)
                .build());
    }
}
