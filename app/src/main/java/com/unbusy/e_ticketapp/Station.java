package com.unbusy.e_ticketapp;

import java.io.Serializable;

public class Station implements Serializable{
    private String stName;
    private String StLocation;
    private String betweenTown_one;
    private String betweenTown_two;

    public Station(String stName, String stLocation, String betweenTown_one, String betweenTown_two) {
        this.stName = stName;
        StLocation = stLocation;
        this.betweenTown_one = betweenTown_one;
        this.betweenTown_two = betweenTown_two;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStLocation() {
        return StLocation;
    }

    public void setStLocation(String stLocation) {
        StLocation = stLocation;
    }

    public String getBetweenTown_one() {
        return betweenTown_one;
    }

    public void setBetweenTown_one(String betweenTown_one) {
        this.betweenTown_one = betweenTown_one;
    }

    public String getBetweenTown_two() {
        return betweenTown_two;
    }

    public void setBetweenTown_two(String betweenTown_two) {
        this.betweenTown_two = betweenTown_two;
    }
}
