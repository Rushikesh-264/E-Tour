package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class ItenaryMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ItenaryId;
	
	public int getItenaryId() {
		return ItenaryId;
	}

	public void setItenaryId(int itenaryId) {
		ItenaryId = itenaryId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getDayNo() {
		return dayNo;
	}

	public void setDayNo(int dayNo) {
		this.dayNo = dayNo;
	}

	public Tours getTours() {
		return tours;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public void setTours(Tours tours) {
		this.tours = tours;
	}

	@Column(nullable=false,length=1000)
	private String Description;
	
	@Column(nullable=false)
	private int dayNo;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tourId",nullable=false)
    @JsonIgnore
	private Tours tours;
	
	private String images;
	
}
