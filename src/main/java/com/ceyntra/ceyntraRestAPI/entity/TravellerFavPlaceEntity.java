package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name ="traveller_favourite_place")
@IdClass(UserPlaceId.class)
public class TravellerFavPlaceEntity {
    @Id
    private int user_id;
    @Id
    private int place_id;

    public TravellerFavPlaceEntity(int user_id, int place_id) {
        this.user_id = user_id;
        this.place_id = place_id;
    }

    public TravellerFavPlaceEntity() {

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
}
