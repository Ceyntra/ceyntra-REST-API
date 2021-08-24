package com.ceyntra.ceyntraRestAPI.model;

import javax.persistence.Id;
import java.io.Serializable;

public class TravellerFavPlaceId implements Serializable {


    private int user_id;
    private int place_id;

    public TravellerFavPlaceId(int user_id, int place_id) {
        this.user_id = user_id;
        this.place_id = place_id;
    }
}
