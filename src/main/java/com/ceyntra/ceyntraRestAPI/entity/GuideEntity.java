package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "guide")
public class GuideEntity {

    @Id
    private int guide_id;
    private String nic;
    private String description;
    private String first_name;
    private String last_name;
    private int number_of_votes;
    private double rating;
    private String vehicle_state;
    private int per_day_price;
    private String profile_photo;
    private String photo;
    private int is_accepted;
    private double latitude;
    private  double longitude;
    private String district;

    public GuideEntity() {
    }

    public GuideEntity(int guide_id, String nic, String description, String first_name, String last_name, int number_of_votes, double rating, String vehicle_state, int per_day_price, String profile_photo, String photo, int is_accepted, double latitude, double longitude, String district) {
        this.guide_id = guide_id;
        this.nic = nic;
        this.description = description;
        this.first_name = first_name;
        this.last_name = last_name;
        this.number_of_votes = number_of_votes;
        this.rating = rating;
        this.vehicle_state = vehicle_state;
        this.per_day_price = per_day_price;
        this.profile_photo = profile_photo;
        this.photo = photo;
        this.is_accepted = is_accepted;
        this.latitude = latitude;
        this.longitude = longitude;
        this.district = district;
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

    public int getPer_day_price() {
        return per_day_price;
    }

    public void setPer_day_price(int per_day_price) {
        this.per_day_price = per_day_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVehicle_state() {
        return vehicle_state;
    }

    public void setVehicle_state(String vehicle_state) {
        this.vehicle_state = vehicle_state;
    }

    public int getGuide_id() {
        return guide_id;
    }

    public void setGuide_id(int guide_id) {
        this.guide_id = guide_id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(int is_accepted) {
        this.is_accepted = is_accepted;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
