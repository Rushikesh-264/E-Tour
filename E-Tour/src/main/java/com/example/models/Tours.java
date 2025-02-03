package com.example.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Tours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tourId;

	private String place;
	
	private String tourName;
	@Column(nullable = false)
	private String imageUrl;
	@Column(nullable = false)
	private String durationDays;
	@Column(nullable = false)
	private String durationNights;
	@Column(nullable = false)
	private double price;
	
	
	private LocalDate startDate;
	private LocalDate endDate;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subCategoryMasterId", nullable = false)
	@JsonIgnore
	private SubcategoryMaster subcategoryMaster;

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

	@OneToMany(mappedBy = "tours", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItenaryMaster> itenaries = new ArrayList<>();

	
	public List<ItenaryMaster> getItenaries() {
		return itenaries;
	}

	public void setItenaries(List<ItenaryMaster> itenaries) {
		this.itenaries = itenaries;
	}
	public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
