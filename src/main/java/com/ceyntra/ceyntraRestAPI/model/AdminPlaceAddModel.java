package com.ceyntra.ceyntraRestAPI.model;

public class AdminPlaceAddModel {

    private String place_name;
    private String description;
    private double latitude;
    private double longitude;
    private String image1;
    private String image2;
    private String image3;


    public AdminPlaceAddModel() {
    }

    public AdminPlaceAddModel(String place_name, String description, double latitude, double longitude, String image1, String image2, String image3) {
        this.place_name = place_name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    @Override
    public String toString() {
        return "AdminPlaceAddModel{" +
                "place_name='" + place_name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                '}';
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }
}
