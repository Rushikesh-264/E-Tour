package com.example.controller;

import com.example.models.Customer;
import com.example.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000") 
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    // Register new customer
    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerServices.saveCustomer(customer);
    }

    // Get customer by ID
    @GetMapping("/{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerServices.getCustomerById(id);
    }

    // Get customer by email for login
    @PostMapping("/login")
    public Customer loginCustomer(@RequestBody Customer customer) {
        Customer existingCustomer = customerServices.getCustomerByEmail(customer.getEmail());
        if (existingCustomer != null && existingCustomer.getPassword().equals(customer.getPassword())) {
            return existingCustomer;
        }
        return null; 
    }
}


