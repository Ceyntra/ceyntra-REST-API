package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name="banned_hotels")
public class BannedHotelsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String email;
    private String telephone;
    private String name;
    private String district;
    private String registration_number;
    private double rating;
    private String profile_photo;

    public BannedHotelsEntity() {
    }

    public BannedHotelsEntity(String email, String telephone, String name, String district, String registration_number, double rating, String profile_photo) {
        this.email = email;
        this.telephone = telephone;
        this.name = name;
        this.district = district;
        this.registration_number = registration_number;
        this.rating = rating;
        this.profile_photo = profile_photo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
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
}
