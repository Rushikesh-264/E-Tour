package com.example.services;

import java.util.Optional;

import com.example.models.Customer;

public interface CustomerServices {
	Customer saveCustomer(Customer customer);
	Optional<Customer> getCustomerById(Long customerId);
	Customer getCustomerByEmail(String email);
}

