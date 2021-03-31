package com.aor.refactoring.example6;

import java.util.*;

public class Tree {
    private final Date plantedAt;
    private Location location;
    private final TreeSet<AppraisalDate> appraisalDates;

    public Tree(Date plantedAt, String locationLatitude, String locationLongitude, String locationName){
        this.plantedAt = plantedAt;
        this.setLocation(locationLatitude, locationLongitude, locationName);
        this.appraisalDates = new TreeSet<>();
    }

    public void setLocation(String locationLatitude, String locationLongitude, String locationName){
        this.location = new Location(locationLatitude, locationLongitude, locationName);
    }
    public Location getLocation() {
        return location;
    }

    public Date getPlantedAt() {
        return plantedAt;
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(new AppraisalDate(appraisalDate));
    }

    public TreeSet<AppraisalDate> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        return getLatestAppraisalDate().nextAppraisalDate().isInThePast();
    }

    private AppraisalDate getLatestAppraisalDate(){
        return this.appraisalDates.isEmpty() ? new AppraisalDate() : this.appraisalDates.last();
    }
}
