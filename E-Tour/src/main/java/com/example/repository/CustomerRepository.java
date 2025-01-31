package com.example.repository;

import com.example.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query ("select count(c)>0 from Customer c where c.email=:email and c.password=:password")
    boolean findByEmail(@Param(value = "email") String email,@Param(value = "password") String password);
}