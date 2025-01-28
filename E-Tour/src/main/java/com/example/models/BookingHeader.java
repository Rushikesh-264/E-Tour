package com.example.models;

import java.sql.Date;

import jakarta.persistence.*;
@Entity	
public class BookingHeader {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingID;
	
	@Column(nullable=false)
	private Date bookingDate;
	
	@Column(nullable=false)
	private int customerID;
	
	@Column(nullable=false)
	private int tourIDs;
	
	@Column(nullable=false)
	private double tourAmount;
	
	public int getBookingID() {
		return bookingID;
	}
	
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	public Date getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getTourID() {
		return tourIDs;
	}
	
	public void setTourID(int tourID) {
		this.tourIDs = tourID;
	}
	
	public double getTourAmount() {
		return tourAmount;
	}
	
	public void setTourAmount(double tourAmount) {
		this.tourAmount = tourAmount;
	}
	
	public double getTourTaxes() {
		return tourTaxes;
	}
	
	public void setTourTaxes(double tourTaxes) {
		this.tourTaxes = tourTaxes;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	private double tourTaxes;
	private double totalAmount;
	
	@ManyToOne      //one customer can book various tours and hence can have those various bookingrecords refer to that one single customer 
	@JoinColumn(name="Customerids", nullable=false)
	private Customer customer;
	
	@ManyToOne      //one tour can be booked by multiple customer, so on each booking = bookingheader will refer to same tour 
	@JoinColumn(name="tourId",nullable=false)
	private Tours tour;
	
	
}