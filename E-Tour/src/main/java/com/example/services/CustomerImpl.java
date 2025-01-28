package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerImpl implements CustomerServices {
	
	@Autowired
	CustomerRepository repository;

	@Override
	public void addCustomer(Customer customer) {
		repository.save(customer);
		
	}

	@Override
	public List<Customer> getCustomers() {
		return repository.findAll();
		
	}

}
