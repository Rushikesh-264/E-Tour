package com.example.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.models.Tours;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import com.example.repository.*;


@Service
public class ToursServiceImpl implements ToursServices {

    @Autowired 
    private ToursRepository toursRepository;

    // Get all tours
   
    public List<Tours> getAllTours() {
        return toursRepository.findAll();
    }

    //Get all tours based on the search
	@Override
	public List<Tours> searchTours(String name, LocalDate startDate, LocalDate endDate) {
		return toursRepository.searchTours(name, startDate, endDate);
	}

}
