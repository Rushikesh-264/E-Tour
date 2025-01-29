package com.example.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.models.Tours;
//import com.example.repositories.ToursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.repository.*;
@Service
public class ToursServiceImpl implements ToursServices {

    @Autowired 
    private ToursRepository toursRepository;

    // Get all tours
   
    public List<Tours> getAllTours() {
        return toursRepository.findAll();
    }

    // Get a single tour by ID
    public Optional<Tours> getTourById(int id) {
        return toursRepository.findById(id);
    }
}
