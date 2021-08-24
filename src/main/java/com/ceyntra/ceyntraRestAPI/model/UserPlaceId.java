package com.ceyntra.ceyntraRestAPI.model;

import javax.persistence.Id;
import java.io.Serializable;

public class UserPlaceId implements Serializable {


    private int user_id;
    private int place_id;

    public UserPlaceId(int user_id, int place_id) {
        this.user_id = user_id;
        this.place_id = place_id;
    }

    public UserPlaceId() {
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
