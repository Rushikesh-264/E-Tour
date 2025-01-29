package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.models.Tours;

public interface ToursServices {
	
	 List<Tours> getAllTours();
	Optional<Tours> getTourById(int id);//Optional<T> is used to avoid null values and handle missing data safely.(NPE)Null pointer exception

}
