package org.example.springhomework003.service;

import org.example.springhomework003.model.Venue;
import org.example.springhomework003.model.request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenue();

    Venue getVenueById(Integer venueId);

    Venue saveVenue(VenueRequest venueRequest);

    Venue updateVenueById(Integer venueId, VenueRequest venueRequest);

    void deleteVenueById(Integer venueId);
}
