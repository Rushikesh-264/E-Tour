package com.example.services;

import com.example.models.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save or update a customer
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

//    // Find a customer by ID
//    public Optional<Customer> getCustomerById(Long customerId) {
//        return customerRepository.findById(customerId);
//    }

    // Find a customer by email
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}


