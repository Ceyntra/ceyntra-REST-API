package com.ceyntra.ceyntraRestAPI.model;

import org.springframework.context.annotation.Bean;

public class CoordinatesModel {
    private double latitude;
    private double longitude;

    public CoordinatesModel() {
    }

    public CoordinatesModel(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
