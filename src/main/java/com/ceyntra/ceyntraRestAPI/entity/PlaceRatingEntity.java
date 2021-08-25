package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UserPlaceId.class)
@Table(name = "traveller_rating_to_place")
public class PlaceRatingEntity {
    @Id
    private int user_id;
    @Id
    private int place_id;
    private double rating;

    public PlaceRatingEntity(int user_id, int place_id, double rating) {
        this.user_id = user_id;
        this.place_id = place_id;
        this.rating = rating;
    }

    public PlaceRatingEntity() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
