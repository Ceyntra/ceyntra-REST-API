package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


public class TravellingPlaceDataModel {


    private String place_name;
    private String description;
    private double latitude;
    private double longitude;
    private int place_added_user_id;
    private String photo;
    private String district;
    private List<String> photoList;


    public TravellingPlaceDataModel() {
    }

    public TravellingPlaceDataModel(String place_name, String description, double latitude, double longitude, int place_added_user_id, String photo, String district, List<String> photoList) {
        this.place_name = place_name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.place_added_user_id = place_added_user_id;
        this.photo = photo;
        this.district = district;
        this.photoList = photoList;
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

    public int getPlace_added_user_id() {
        return place_added_user_id;
    }

    public void setPlace_added_user_id(int place_added_user_id) {
        this.place_added_user_id = place_added_user_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public List<String> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<String> photoList) {
        this.photoList = photoList;
    }
}
