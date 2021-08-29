package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.TravellerSpId;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TravellerSpId.class)
@Table(name = "traveller_rating_to_sp")
public class SpRatingEntity {
    @Id
    private int traveller_id;
    @Id
    private int sp_id;
    private int sp_user_type;
    private double rating;

    public SpRatingEntity() {
    }

    public SpRatingEntity(int traveller_id, int sp_id, int sp_user_type, double rating) {
        this.traveller_id = traveller_id;
        this.sp_id = sp_id;
        this.sp_user_type = sp_user_type;
        this.rating = rating;
    }

    public int getTraveller_id() {
        return traveller_id;
    }

    public void setTraveller_id(int traveller_id) {
        this.traveller_id = traveller_id;
    }

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public int getSp_user_type() {
        return sp_user_type;
    }

    public void setSp_user_type(int sp_user_type) {
        this.sp_user_type = sp_user_type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
