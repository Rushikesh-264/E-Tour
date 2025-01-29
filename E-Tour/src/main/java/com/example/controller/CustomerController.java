package com.example.controller;

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

    // READ: Login Customer
    @PostMapping("/validate")
  
    	public ResponseEntity<Boolean> validateCustomer(@RequestParam String email, @RequestParam String password) {
            boolean isValid = customerService.validateCustomer(email, password);
            return ResponseEntity.ok(isValid);
    }
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestParam String firstName, @RequestParam String lastName,
                                                      @RequestParam String email, @RequestParam String password) {
        Customer customer = customerService.registerCustomer(firstName, lastName, email, password);
        return ResponseEntity.ok(customer);
    }
    
}
