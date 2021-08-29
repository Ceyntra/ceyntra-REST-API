package com.ceyntra.ceyntraRestAPI.model;

import java.io.Serializable;

public class TravellerSpId implements Serializable {
    private int traveller_id;
    private int sp_id;

    public TravellerSpId() {
    }

    public TravellerSpId(int traveller_id, int sp_id) {
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
