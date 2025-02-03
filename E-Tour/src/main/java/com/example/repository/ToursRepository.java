package com.example.repository;

import com.example.models.Tours;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ToursRepository extends JpaRepository<Tours, Integer> {

	// Customized Query to Search by place (tour name) or start or end date
	
	@Query(value = "SELECT * FROM Tours t WHERE " +
	        "(:place IS NULL OR t.place LIKE CONCAT('%', :place, '%')) AND " +
	        "(:startDate IS NULL OR t.start_date >= :startDate) AND " +
	        "(:endDate IS NULL OR t.end_date <= :endDate)", nativeQuery = true)
	List<Tours> searchTours(String place, LocalDate startDate, LocalDate endDate);


}
