package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.BookingHeader;
import com.example.services.IPaymentConfirmationService;

@RestController
@RequestMapping("/api/subcategory/{categoryId}/tours/{tourId}/itenary/booking/bookingConfirmation")
public class PaymentConfirmationController {
	
	@Autowired
	IPaymentConfirmationService PaymentConfirmationService; 

	@PostMapping("/save")
	public ResponseEntity<String> confirmBooking(@RequestBody BookingHeader bookingheader)
	{
         
		  try {
			  PaymentConfirmationService.createBooking(bookingheader);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Booking created successfully!");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating booking.");
	        }
	}
}
