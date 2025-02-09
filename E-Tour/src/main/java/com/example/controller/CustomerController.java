package com.example.controller;

import com.example.models.Customer;
import com.example.services.CustomerServices;

import java.util.HashMap;
import java.util.Map;
=======
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:3000") 
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;
    
    // Register new customer
    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerServices.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCustomer);
    }

//    // Get customer by ID
  @GetMapping("/{id}")
  public Optional<Customer> getCustomerById(@PathVariable Long id) {
        return customerServices.getCustomerById(id);
   }
  //tushar@example.com, Tushar@1234
  @PostMapping("/signIn")
  public ResponseEntity<String> signIn(){
  	return new ResponseEntity<>("Signin Successfully",HttpStatus.OK);

  /*
    // Get customer by email for login
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        boolean found = customerServices.getCustomerByEmail(customer);

        if (found) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login Successful");
            return ResponseEntity.ok(response);
        }

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Invalid email or password.");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
=======
    public ResponseEntity<?> loginCustomer(@RequestBody Customer customer)
    {
    	System.out.println(customer);
    	boolean found = customerServices.getCustomerByEmail(customer);
    	if(found)
    	{
    		return ResponseEntity.ok("Login Successfull");
    	}
    	
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid");
//    	Map<String, String> errorResponse = new HashMap<>();
//        errorResponse.put("message", "Invalid email or password.");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
//
 */
    }

}