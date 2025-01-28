package com.example.models;

import jakarta.persistence.*;

@Entity
public class Tours {
	
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(String durationDays) {
		this.durationDays = durationDays;
	}

	public String getDurationNights() {
		return durationNights;
	}

	public void setDurationNights(String durationNights) {
		this.durationNights = durationNights;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SubcategoryMaster getSubcategoryMaster() {
		return subcategoryMaster;
	}

	public void setSubcategoryMaster(SubcategoryMaster subcategoryMaster) {
		this.subcategoryMaster = subcategoryMaster;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tourId;
	
	@Column(nullable=false,length=100)
	private String tourName;
	@Column(nullable=false,length=250)
	private String imageUrl;
	@Column(nullable=false)
	private String durationDays;
	@Column(nullable=false)
	private String durationNights;
	@Column(nullable=false)
	private double price;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subCategoryMasterId",nullable=false)
	private SubcategoryMaster subcategoryMaster; 
}
