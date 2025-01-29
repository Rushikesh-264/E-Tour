package com.example.controller;

import com.example.models.Tours;
import com.example.services.ToursServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tours")
public class ToursController {

    @Autowired
    private ToursServices toursService;

    // Get all tours
    @GetMapping
    public List<Tours> getAllTours() {
        return toursService.getAllTours();
    }

    // Get tour by ID
    @GetMapping("/{id}")
    public Optional<Tours> getTourById(@PathVariable int id) {
        return toursService.getTourById(id);
    }
}
