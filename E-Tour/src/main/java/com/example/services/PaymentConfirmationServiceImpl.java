package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.BookingHeader;
import com.example.models.BookingStatus;
import com.example.models.PaymentStatus;
import com.example.repository.PaymentConfirmationRepository;
@Service
public class PaymentConfirmationServiceImpl implements IPaymentConfirmationService {

    @Autowired
    PaymentConfirmationRepository paymConfirmationRepository;

    // To save the Booking details after successful payment
    public void createBooking(BookingHeader bookingdetails) {
        // Creating a new BookingHeader object to save the details
        BookingHeader bookingHeader = new BookingHeader();

        // Setting values from bookingdetails (the incoming parameter)
        bookingHeader.setBookingDate(bookingdetails.getBookingDate()); 
        bookingHeader.setCustomerId(bookingdetails.getCustomerId());
        bookingHeader.setTourId(bookingdetails.getTourId());
        bookingHeader.setTourAmount(bookingdetails.getTourAmount()); 
        bookingHeader.setTotalAmount(bookingdetails.getTotalAmount()); 
        bookingHeader.setNumberOfPassengers(bookingdetails.getNumberOfPassengers()); 
        bookingHeader.setTourname(bookingdetails.getTourname()); 
        bookingHeader.setCustomername(bookingdetails.getCustomername()); 

        // Setting booking and payment status
        bookingHeader.setBookingStatus(BookingStatus.CONFIRMED); 
        bookingHeader.setPaymentStatus(PaymentStatus.COMPLETED); 
        
        // Generate and set transaction ID
        String transactionId = generateTransactionId();
        bookingHeader.setTransactionId(transactionId);

        // Save the booking to the database
        paymConfirmationRepository.save(bookingHeader);
    }

    // Method to generate random transaction ID
    private String generateTransactionId() {
        return "TCN-" + System.currentTimeMillis() + "-" + (int) (Math.random() * 10000);
    }
}