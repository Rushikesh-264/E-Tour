package com.example.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
	private int tourID;
	
	@Column(nullable=false)
	private double tourAmount;
	
	public int getBookingID() {
		return bookingID;
	}
	
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	
	public int getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(int bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getTourID() {
		return tourID;
	}
	
	public void setTourID(int tourID) {
		this.tourID = tourID;
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
	@JoinColumn(name="Customerid", referencedColumnName="Cust-id" , nullable=false)
	private Customer customer;
	
	@ManyToOne      //one tour can be booked by multiple customer, so on each booking = bookingheader will refer to same tour 
	@JoinColumn(name="Tourid",referencedColumnName="Tour-id",nullable=false)
	private Tour tour;
	
	@Override
	public String toString() {
		return "BookingHeader [bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", customerID=" + customerID
				+ ", tourID=" + tourID + ", tourAmount=" + tourAmount + ", tourTaxes=" + tourTaxes + ", totalAmount="
				+ totalAmount + "]";
	}
}
