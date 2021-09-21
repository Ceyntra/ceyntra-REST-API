package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name="banned_guide")
public class BannedGuideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private String first_name;
    private String last_name;
    private String nic;
    private String district;
    private String email;
    private String telephone;
    private double rating;
    private String profile_photo;

    public BannedGuideEntity() {
    }

    public BannedGuideEntity(String first_name, String last_name, String nic, String district, String email, String telephone, double rating, String profile_photo) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nic = nic;
        this.district = district;
        this.email = email;
        this.telephone = telephone;
        this.rating = rating;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getProfile_photo() {
        return profile_photo;
    }

    public void setProfile_photo(String profile_photo) {
        this.profile_photo = profile_photo;
    }
}
