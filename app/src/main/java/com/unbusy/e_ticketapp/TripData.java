package com.unbusy.e_ticketapp;

import android.util.Log;

import com.unbusy.e_ticketapp.TrainData;

import java.io.Serializable;

public class TripData implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String TAG = "TripDat";

    private String trainName;
    private String compartmentType;
    private String departureDate;
    private String departureTime;
    private String arrivalTime;

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    private String fromPlace;
    private String toPlace;
    private float tripCost;
    private int numberOfPassengers;
    public Station boardingPoint;
    public Station dropOffPoint;

    public Station getBoardingPoint() {
        return boardingPoint;
    }

    public void setBoardingPoint(Station boardingPoint) {
        this.boardingPoint = boardingPoint;
    }

    public Station getDropOffPoint() {
        return dropOffPoint;
    }

    public void setDropOffPoint(Station dropOffPoint) {
        this.dropOffPoint = dropOffPoint;
    }

    private String[] seatNumbers;

    public TripData() {
        this.numberOfPassengers = 1;
    }

    public TripData(String trainName, String compartmentType, String departureDate, String departureTime, String fromPlace, String toPlace, float tripCost, int numberOfPassengers) {
        this.trainName = trainName;
        this.compartmentType = compartmentType;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.tripCost = tripCost;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String[] getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(String[] seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

//    public TrainData getTrainData() {
//        return trainData;
//    }
//
//    public void setTrainData(TrainData trainData) {
//        this.trainData = trainData;
//    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getCompartmentType() {
        return compartmentType;
    }

    public void setCompartmentType(String compartmentType) {
        this.compartmentType = compartmentType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public float getTripCost() {
        Log.d(TAG, "getTripCost: " + getNumberOfPassengers());return tripCost * this.getNumberOfPassengers();
    }

    public void setTripCost(float tripCost) {
        Log.d(TAG, "setTripCost: " + getNumberOfPassengers());
        Log.d(TAG, "setTripCost: " + tripCost);
        this.tripCost = tripCost * numberOfPassengers;
    }

    @Override
    public String toString() {
        return "TripData [trainName="+ trainName +",compartmentType="+ compartmentType +",departureDate=" + departureDate + ",departureTime=" + departureTime + ",fromPlace="+ fromPlace +",toPlace="+ toPlace +",tripCost=" + tripCost + ",numberOfPassengers=" + numberOfPassengers + ",seatNumbers=" + seatNumbers + "]";
//        return "TripData [name=" + name + ", age=" + age + "]";
    }
}
