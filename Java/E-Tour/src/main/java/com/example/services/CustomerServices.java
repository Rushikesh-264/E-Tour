package com.example.services;

import java.util.Optional;

import com.example.models.Customer;

public interface CustomerServices {
	Customer saveCustomer(Customer customer);
	//Optional<Customer> getCustomerById(Long customerId);
	boolean getCustomerByEmail(Customer customer);
	Optional<Customer> getCustomerById(Long customerId);
	Optional<Customer> getCustomerByEmail(String email);

}
