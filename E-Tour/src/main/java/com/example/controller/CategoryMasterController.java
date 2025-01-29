package com.example.controller;

import com.example.models.CategoryMaster;
import com.example.repository.CategoryMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryMasterController {
 
    private final CategoryMasterRepository categoryMasterRepository;

    @Autowired
    public CategoryMasterController(CategoryMasterRepository categoryMasterRepository) {
        this.categoryMasterRepository = categoryMasterRepository;
    }

    @GetMapping("/")
    public List<CategoryMaster> getAllCategories() {
    	
    	List<CategoryMaster>categorymaster = categoryMasterRepository.findAll();
		return categorymaster;
        }
    
	@GetMapping("/{id}")
	public CategoryMaster getCatMaster_id(@PathVariable int id)
	{
		CategoryMaster categorymaster=categoryMasterRepository.findById(id).get();
		
		return categorymaster;
	}
} 