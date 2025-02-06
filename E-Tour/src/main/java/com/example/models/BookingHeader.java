package com.example.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookingHeader {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingID")
    private int bookingID;
	

	@Column(name = "bookingDate", nullable = false,updatable=false)
    private LocalDateTime bookingDate;

    @Column(name = "customerId", nullable = false)
    private int customerId;

    @Column(name = "tourId", nullable = false)
    private int tourId;

    @Column(name = "tourAmount", nullable = false)
    private double tourAmount;

    @Column(name = "totalAmount", nullable = false)
    private double totalAmount;

    @Column(name = "transactionId")
    private String transactionId;

    @Column(name = "numberOfPassengers", nullable = true)
    private int numberOfPassengers = 1; // Default to 1

    @Column(name = "tourname", nullable = true)
    private String tourname;

    @Column(name = "customerName", nullable = true)
    private String customerName;

    // Enum for booking status
    @Enumerated(EnumType.STRING)
    @Column(name = "bookingStatus", nullable = false)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    // Enum for payment status
    @Enumerated(EnumType.STRING)
    @Column(name = "paymentStatus", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public double getTourAmount() {
		return tourAmount;
	}

	public void setTourAmount(double tourAmount) {
		this.tourAmount = tourAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public String getTourname() {
		return tourname;
	}

	public void setTourname(String tourname) {
		this.tourname = tourname;
	}

	public String getCustomername() {
		return customerName;
	}

	public void setCustomername(String customername) {
		this.customerName = customername;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
		
}
