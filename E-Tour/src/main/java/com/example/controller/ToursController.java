package com.example.controller;

import com.example.models.ApiResponse;
import com.example.models.Tours;
import com.example.services.ToursServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/subcategory/tours")
public class ToursController {

    @Autowired
    private ToursServices toursService;

    // Get all tours
    @GetMapping
    public ResponseEntity<List<Tours>> getAllTours() {
        try {
            List<Tours> tours = toursService.getAllTours();
            return ResponseEntity.ok(tours);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @GetMapping("/search")
    public ResponseEntity<ApiResponse> searchTours(@RequestParam(required = false) String place, 
                                                    @RequestParam(required = false) LocalDate startDate, 
                                                    @RequestParam(required = false) LocalDate endDate) {

    	// Return a successful response even if no tours are found, but include a message
        try {
            List<Tours> tours = toursService.searchTours(place, startDate, endDate);
            if (tours.isEmpty()) {
                ApiResponse response = new ApiResponse(tours, "No tours found matching the criteria");
                return ResponseEntity.ok(response);  // Return 200 OK with empty list and message
            }
            ApiResponse response = new ApiResponse(tours, "Tours found");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
