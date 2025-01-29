package com.example.controller;

import com.example.dto.LoginDto;
import com.example.models.Customer;
import com.example.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// CREATE: Create or update a customer
	@PostMapping("/")
	public ResponseEntity<Customer> createOrUpdateCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
	}

	// Allow only this origin
	// READ: Login Customer
	@PostMapping("/validate")
	public ResponseEntity<Boolean> validateCustomer(@RequestBody LoginDto loginDto) {
		boolean isValid = customerService.validateCustomer(loginDto.getEmail(), loginDto.getPassword());
		return ResponseEntity.ok(isValid);
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomer(@RequestBody String firstName, @RequestBody String lastName,
			@RequestBody String email, @RequestBody String password) {
		Customer customer = customerService.registerCustomer(firstName, lastName, email, password);
		return ResponseEntity.ok(customer);
	}

}
