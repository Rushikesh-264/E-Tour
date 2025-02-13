package com.example.models;

import java.sql.Date;
import jakarta.persistence.*;


@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Paxid;
	
	@JoinColumn(name="bookingID", referencedColumnName="bookingID", nullable=false)
	//private BookingHeader bookingheader;
	
	private Date Birthdate;
	private String Type;
	private double Amount;
	
	
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
	
	
}