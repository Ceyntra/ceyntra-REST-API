package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="traveller_rating_to_place")
@IdClass(UserPlaceId.class)
public class PlaceReviewEntity {
    @Id
    @Column(name = "traveller_id")
    private int user_id;
    @Id
    private int place_id;
    private String comment;
    private double rating;
    private Timestamp timestamp;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
