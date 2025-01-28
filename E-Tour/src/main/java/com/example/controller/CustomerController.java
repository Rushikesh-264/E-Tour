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
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // CREATE: Create or update a customer
    @PostMapping("/")
    public ResponseEntity<Customer> createOrUpdateCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
//
//    // READ: Get a customer by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
//        Optional<Customer> customer = customerService.getCustomerById(id);
//        return customer.map(ResponseEntity::ok)
//                       .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//    }
//
    // READ: Get a customer by email
    @GetMapping("/username/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        return customer != null ? ResponseEntity.ok(customer)
                                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
