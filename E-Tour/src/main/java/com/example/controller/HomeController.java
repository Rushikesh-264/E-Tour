package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.CategoryMaster;
import com.example.services.HomeServices;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/api")
public class HomeController {
	@Autowired 
	private HomeServices homeservices;

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@GetMapping("")
	public List<CategoryMaster> getAllCategories()
	{
		List<CategoryMaster> categories = homeservices.getAllCategories();
		logger.info("getAllCategories() method called");
		logger.debug("Categories fetched: "+categories);
		return categories;
	}
}
