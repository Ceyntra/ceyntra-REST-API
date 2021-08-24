package com.ceyntra.ceyntraRestAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "travelling_place")
public class TravellingPlaceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int place_id;
    private String place_name;
    private String description;
    private double latitude;
    private double longitude;
    private int place_added_user_id;
    private double rating;
    private int number_of_votes;
    private String photo;
    private int is_accepted;

    public TravellingPlaceModel() {
    }

    public TravellingPlaceModel(int place_id, String place_name, String description, double latitude, double longitude, int place_added_user_id, double rating, int number_of_votes, String photo,int is_accepted) {
        this.place_id = place_id;
        this.place_name = place_name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.place_added_user_id = place_added_user_id;
        this.rating = rating;
        this.number_of_votes = number_of_votes;
        this.photo = photo;
        this.is_accepted = is_accepted;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumber_of_votes() {
        return number_of_votes;
    }

    public void setNumber_of_votes(int number_of_votes) {
        this.number_of_votes = number_of_votes;
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
}
