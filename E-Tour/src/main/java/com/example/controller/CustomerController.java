package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.CustomerServices;

@RestController
//@CrossOrigin("http://127.0.0.1:5500")
public class CustomerController {
	
	@Autowired
	CustomerServices services;
}
