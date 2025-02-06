package com.example.models;
import jakarta.persistence.*;

@Entity
public class CostMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CostId;
	
	@Column(name="TwinSharingcost",nullable=false)
	private int TwinSharingcost;
	
	private int extraPersonCost;
	private int childWithBed;
	private int childWitoutBed;
	
	@OneToOne
	@JoinColumn(name="tourId",nullable=false)
	private Tours tour;
	
	public int getCostId() {
		return CostId;
	}

	public void setCostId(int costId) {
		CostId = costId;
	}

	public int getTwinSharingcost() {
		return TwinSharingcost;
	}

	public void setTwinSharingcost(int singlePersonCost) {
		this.TwinSharingcost = singlePersonCost;
	}

	public int getExtraPersonCost() {
		return extraPersonCost;
	}

	public void setExtraPersonCost(int extraPersonCost) {
		this.extraPersonCost = extraPersonCost;
	}

	public int getChildWithBed() {
		return childWithBed;
	}

	public void setChildWithBed(int childWithBed) {
		this.childWithBed = childWithBed;
	}

	public int getChildWitoutBed() {
		return childWitoutBed;
	}

	public void setChildWitoutBed(int childWitoutBed) {
		this.childWitoutBed = childWitoutBed;
	}

	public Tours getTour() {
		return tour;
	}

	public void setTour(Tours tour) {
		this.tour = tour;
	}
	
}
