package org.example.springhomework003.service.impl;

import org.example.springhomework003.model.Venue;
import org.example.springhomework003.model.request.VenueRequest;
import org.example.springhomework003.repository.VenueRepository;
import org.example.springhomework003.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @Override
    public List<Venue> getAllVenue() {
        return venueRepository.getAllVenue();
    }

    @Override
    public Venue getVenueById(Integer venueId) {
        return venueRepository.findVenueById(venueId);
    }

    @Override
    public Venue saveVenue(VenueRequest venueRequest) {
        return venueRepository.saveVenue(venueRequest);
    }

    @Override
    public Venue updateVenueById(Integer venueId, VenueRequest venueRequest) {
        return venueRepository.updateVenueById(venueId, venueRequest);
    }

    @Override
    public void deleteVenueById(Integer venueId) {
        venueRepository.deleteVenueById(venueId);
    }
}
