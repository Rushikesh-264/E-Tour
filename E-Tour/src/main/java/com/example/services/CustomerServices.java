package com.example.services;

import java.util.List;

import com.example.models.Customer;

public interface CustomerServices {
	void addCustomer(Customer customer);
	List<Customer>getCustomers();
}
