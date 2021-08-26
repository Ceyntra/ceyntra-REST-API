package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="traveller_review_to_place")

public class PlaceReviewEntity {
    @Id
    private int review_id;
    @Column(name = "traveller_id")
    private int user_id;
    private int place_id;
    private String comment;
    private Timestamp timestamp;

    public PlaceReviewEntity(int user_id, int place_id, String comment, Timestamp timestamp) {
        this.user_id = user_id;
        this.place_id = place_id;
        this.comment = comment;
        this.timestamp = timestamp;

    }

    public PlaceReviewEntity() {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
