package com.longdy.cityapp;

import java.io.Serializable;

public class Location implements Serializable {
    double longitude;
    double latitude;
    public Location(double Longitude,double Latitude){
        this.longitude = Longitude;
        this.latitude = Latitude;
    }
    public  void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    @Override
    public String toString() {
        return "Latitude: " + latitude + "\n"+"Longitude: " + longitude;
    }
}