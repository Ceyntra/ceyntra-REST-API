package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxi_driver")
public class TaxiDriverEntity {

    @Id
    private int taxi_driver_id;
    private String driver_license;
    private String first_name;
    private String last_name;
    private double working_latitude;
    private double working_longitude;
    private int per_km_price;
    private int number_of_votes;
    private double rating;
    private String profile_photo;
    private String taxi_photo;


    public TaxiDriverEntity() {
    }

    public TaxiDriverEntity(int taxi_driver_id, String driver_license, String first_name, String last_name, double working_latitude, double working_longitude, int per_km_price, int number_of_votes, double rating, String profile_photo, String taxi_photo) {
        this.taxi_driver_id = taxi_driver_id;
        this.driver_license = driver_license;
        this.first_name = first_name;
        this.last_name = last_name;
        this.working_latitude = working_latitude;
        this.working_longitude = working_longitude;
        this.per_km_price = per_km_price;
        this.number_of_votes = number_of_votes;
        this.rating = rating;
        this.profile_photo = profile_photo;
        this.taxi_photo = taxi_photo;
    }


    public int getPer_km_price() {
        return per_km_price;
    }

    public void setPer_km_price(int per_km_price) {
        this.per_km_price = per_km_price;
    }

    public int getTaxi_driver_id() {
        return taxi_driver_id;
    }

    public void setTaxi_driver_id(int taxi_driver_id) {
        this.taxi_driver_id = taxi_driver_id;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getWorking_latitude() {
        return working_latitude;
    }

    public void setWorking_latitude(double working_latitude) {
        this.working_latitude = working_latitude;
    }

    public double getWorking_longitude() {
        return working_longitude;
    }

    public void setWorking_longitude(double working_longitude) {
        this.working_longitude = working_longitude;
    }

    public int getNumber_of_votes() {
        return number_of_votes;
    }

    public void setNumber_of_votes(int number_of_votes) {
        this.number_of_votes = number_of_votes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }

    public String getTaxi_photo() {
        return taxi_photo;
    }

    public void setTaxi_photo(String taxi_photo) {
        this.taxi_photo = taxi_photo;
    }
}
