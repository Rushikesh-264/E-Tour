package com.example.repository;

import com.example.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can define custom query methods here if needed, e.g., finding by email.
    Customer findByEmail(String email);
}