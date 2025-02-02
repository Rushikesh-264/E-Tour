package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.SubcategoryMaster;
import com.example.services.SubcategoryMasterServices;

@RestController
@RequestMapping("api/subcategory")
public class SubcategoryController {

	 @Autowired
	    private SubcategoryMasterServices service;

	    // Get all subcategories
	    @GetMapping("/")
	    public List<SubcategoryMaster> getAllSubcategories() {
	        return service.getAllSubcategory();
	    }

}
