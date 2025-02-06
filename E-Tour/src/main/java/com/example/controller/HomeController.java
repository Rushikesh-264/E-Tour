package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.CategoryMaster;
import com.example.services.HomeServices;

@RestController
@RequestMapping("/api")
public class HomeController {
	@Autowired 
	private HomeServices homeservices;

	
	@GetMapping("")
	public List<CategoryMaster> getAllCategories()
	{
		return homeservices.getAllCategories();
	}
}

