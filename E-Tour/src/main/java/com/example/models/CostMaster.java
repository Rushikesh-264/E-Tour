package com.example.models;
import jakarta.persistence.*;

@Entity
public class CostMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CostId;
	
	public int getCostId() {
		return CostId;
	}

	public void setCostId(int costId) {
		CostId = costId;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getSinglePersonCost() {
		return singlePersonCost;
	}

	public void setSinglePersonCost(int singlePersonCost) {
		this.singlePersonCost = singlePersonCost;
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

	@Column(nullable=false)
	private double cost;
	
	@Column(nullable=false)
	private int singlePersonCost;
	
	private int extraPersonCost;
	private int childWithBed;
	private int childWitoutBed;
	
	@OneToOne
	@JoinColumn(name="tourId",nullable=false)
	private Tours tour;
	
}
