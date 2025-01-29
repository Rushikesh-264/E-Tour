package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.CategoryMaster;
import com.example.services.CategoryMasterService;

@RestController
@RequestMapping("/categories")
public class CategoryMasterController {
	 @Autowired
	    private CategoryMasterService categoryMasterService;

	    // Get all categories
	    @GetMapping
	    public ResponseEntity<List<CategoryMaster>> getAllCategories() {
	        return ResponseEntity.ok(categoryMasterService.getAllCategories());
	    }

	    // Get category by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<CategoryMaster> getCategoryById(@PathVariable int id) {
	        Optional<CategoryMaster> category = categoryMasterService.getCategoryById(id);
	        return category.map(ResponseEntity::ok)
	                       .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	   

	   

	   
}
