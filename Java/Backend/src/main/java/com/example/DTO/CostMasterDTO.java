package com.example.DTO;

public class CostMasterDTO {

    private int costId;
    private int twinSharingcost;
    private int extraPersonCost;
    private int childWithBed;
    private int childWitoutBed;

    
    public CostMasterDTO() {}

    public CostMasterDTO(int costId, int twinSharingcost, int extraPersonCost, int childWithBed, int childWitoutBed) {
        this.costId = costId;
        this.twinSharingcost = twinSharingcost;
        this.extraPersonCost = extraPersonCost;
        this.childWithBed = childWithBed;
        this.childWitoutBed = childWitoutBed;
    }

    public int getCostId() {
        return costId;
    }

    public void setCostId(int costId) {
        this.costId = costId;
    }

    public int getTwinSharingcost() {
        return twinSharingcost;
    }

    public void setTwinSharingcost(int twinSharingcost) {
        this.twinSharingcost = twinSharingcost;
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
}
