package com.example.services;

import com.example.models.Customer;
import com.example.repository.CustomerRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   
    public boolean validateCustomer(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password).isPresent();
    }
    public Customer registerCustomer(String firstName, String lastName, String email, String password) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPassword(password);
        return customerRepository.save(customer);
    }
}


