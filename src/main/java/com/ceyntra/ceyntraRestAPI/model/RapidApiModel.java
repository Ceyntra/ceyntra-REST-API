package com.ceyntra.ceyntraRestAPI.model;

public class RapidApiModel {
    private StartPoint start_point;
    private EndPoint end_point;
    private double distance;
    private String unit;

    public StartPoint getStart_point() {
        return start_point;
    }

    public void setStart_point(StartPoint start_point) {
        this.start_point = start_point;
    }

    public EndPoint getEnd_point() {
        return end_point;
    }

    public void setEnd_point(EndPoint end_point) {
        this.end_point = end_point;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
class StartPoint{
    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    private String coordinate;
}

class EndPoint{
    private String coordinate;

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}

