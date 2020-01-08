package com.unbusy.e_ticketapp;

import java.io.Serializable;

public class TrainData implements Serializable{

    private String trainName;
    private String compartmentType;
    private int seatsLeft;
    private int trainStops;
    private String arrivalTime;
    private String departureTime;
    private String fromPlace;
    private String toPlace;
    private float tripCost;

    public TrainData(){

    }

    public TrainData(String trainName, String compartmentType, int seatsLeft, int trainStops, String arrivalTime, String departureTime, String fromPlace, String toPlace, float tripCost) {
        this.trainName = trainName;
        this.compartmentType = compartmentType;
        this.seatsLeft = seatsLeft;
        this.trainStops = trainStops;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.tripCost = tripCost;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getCompartmentType() {
        return compartmentType;
    }

    public void setCompartmentType(String compartmentType) {
        this.compartmentType = compartmentType;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public int getTrainStops() {
        return trainStops;
    }

    public void setTrainStops(int trainStops) {
        this.trainStops = trainStops;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public float getTripCost() {
        return tripCost;
    }

    public void setTripCost(float tripCost) {
        this.tripCost = tripCost;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }
}
