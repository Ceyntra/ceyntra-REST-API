package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name = "banned_taxi")
public class BannedTaxiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String first_name;
    private String last_name;
    private String driver_license;
    private String email;
    private String telephone;
    private double rating;
    private String district;
    private String profile_photo;

    public BannedTaxiEntity() {
    }

    public BannedTaxiEntity(String first_name, String last_name, String driver_license, String email, String telephone, double rating, String district, String profile_photo) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.driver_license = driver_license;
        this.email = email;
        this.telephone = telephone;
        this.rating = rating;
        this.district = district;
        this.profile_photo = profile_photo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }
}
