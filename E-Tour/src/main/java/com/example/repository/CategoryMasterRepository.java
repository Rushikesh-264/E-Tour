package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.CategoryMaster;

public interface CategoryMasterRepository extends JpaRepository<CategoryMaster, Integer> {

	List<CategoryMaster> findAll();
	
}
