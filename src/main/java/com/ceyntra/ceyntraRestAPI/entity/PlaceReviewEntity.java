package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="place_review")
@IdClass(UserPlaceId.class)
public class PlaceReviewEntity {
    @Id
    private int traveller_id;
    @Id
    private int place_id;
    private String comment;
    private double rating;
    private Timestamp timestamp;

    public int getTraveller_id() {
        return traveller_id;
    }

    public void setTraveller_id(int traveller_id) {
        this.traveller_id = traveller_id;
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
