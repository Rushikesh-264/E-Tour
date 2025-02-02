package com.example.services;

import java.time.LocalDate;
import java.util.List;

import com.example.models.Tours;

public interface ToursServices {
	
	 List<Tours> getAllTours();
	 List<Tours> searchTours(String name,LocalDate startDate,LocalDate endDate);
}
