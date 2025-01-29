package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.CategoryMaster;
import com.example.repository.CategoryRepository;

@Service
public class CategoryMasterServiceImpl implements CategoryMasterService{

	 @Autowired
	    private CategoryRepository categoryMasterRepository;

	    // Get all categories
	 @Override
	    public List<CategoryMaster> getAllCategories() {
	        return categoryMasterRepository.findAll();
	    }

	    // Get category by ID
	 @Override
	    public Optional<CategoryMaster> getCategoryById(int id) {
	        return categoryMasterRepository.findById(id);
	    }

	   
	   

	   
}
