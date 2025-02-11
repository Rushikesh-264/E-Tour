package com.example.services;

import com.example.models.Customer;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.repository.CustomerRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerServices{

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private PasswordEncoder encoder;

    // Save or update a customer
    @Override
    public Customer saveCustomer(Customer customer) {
    	customer.setPassword(encoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

//    // Find a customer by ID
    @Override
    public Optional<Customer> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
	public  Optional<Customer> getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
		
	}

	@Override
	public boolean getCustomerByEmail(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	

    // Find a customer by email
   /* @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }*/
}