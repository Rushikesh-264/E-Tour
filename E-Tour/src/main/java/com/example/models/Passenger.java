package com.example.Models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Paxid;
	
	@JoinColumn(name="", referencedColumnName="", nullable=false)
	private BookingHeader bookingheader;
	
	private String Paxname;
	
	public int getPaxid() {
		return Paxid;
	}
	public void setPaxid(int paxid) {
		Paxid = paxid;
	}
	public String getPaxname() {
		return Paxname;
	}
	public void setPaxname(String paxname) {
		Paxname = paxname;
	}
	public Date getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	private Date Birthdate;
	private String Type;
	private double Amount;
	
	@Override
	public String toString() {
		return "Passenger [Paxid=" + Paxid + ", Paxname=" + Paxname + ", Birthdate=" + Birthdate + ", Type=" + Type
				+ ", Amount=" + Amount + "]";
	}
}
