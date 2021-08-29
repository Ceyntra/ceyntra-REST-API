package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.TravellerSpId;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name ="traveller_favourite_sp")
@IdClass(TravellerSpId.class)
public class TravellerFavSpEntity {
    @Id
    private int traveller_id;
    @Id
    private int sp_id;

    public TravellerFavSpEntity() {
    }

    public TravellerFavSpEntity(int traveller_id, int sp_id) {
        this.traveller_id = traveller_id;
        this.sp_id = sp_id;
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
}
