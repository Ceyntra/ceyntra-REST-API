package com.ceyntra.ceyntraRestAPI.entity;

import com.ceyntra.ceyntraRestAPI.model.BidAcceptedId;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "bid_accepted_details")
@IdClass(BidAcceptedId.class)
public class BidAcceptedDetailsEntity {

    @Id
    private int bid_id;
    @Id
    private int taxi_driver_id;
    private int taxi_driver_accept;
    private int taxi_driver_reject;
    private int traveller_accept;
    private int traveller_reject;
    private int activeState;

    public BidAcceptedDetailsEntity() {
    }

    public BidAcceptedDetailsEntity(int bid_id, int taxi_driver_id, int taxi_driver_accept, int taxi_driver_reject, int traveller_accept, int traveller_reject, int activeState) {
        this.bid_id = bid_id;
        this.taxi_driver_id = taxi_driver_id;
        this.taxi_driver_accept = taxi_driver_accept;
        this.taxi_driver_reject = taxi_driver_reject;
        this.traveller_accept = traveller_accept;
        this.traveller_reject = traveller_reject;
        this.activeState = activeState;
    }

    public int getActiveState() {
        return activeState;
    }

    public void setActiveState(int activeState) {
        this.activeState = activeState;
    }

    public int getBid_id() {
        return bid_id;
    }

    public void setBid_id(int bid_id) {
        this.bid_id = bid_id;
    }

    public int getTaxi_driver_id() {
        return taxi_driver_id;
    }

    public void setTaxi_driver_id(int taxi_driver_id) {
        this.taxi_driver_id = taxi_driver_id;
    }

    public int getTaxi_driver_accept() {
        return taxi_driver_accept;
    }

    public void setTaxi_driver_accept(int taxi_driver_accept) {
        this.taxi_driver_accept = taxi_driver_accept;
    }

    public int getTaxi_driver_reject() {
        return taxi_driver_reject;
    }

    public void setTaxi_driver_reject(int taxi_driver_reject) {
        this.taxi_driver_reject = taxi_driver_reject;
    }

    public int getTraveller_accept() {
        return traveller_accept;
    }

    public void setTraveller_accept(int traveller_accept) {
        this.traveller_accept = traveller_accept;
    }

    public int getTraveller_reject() {
        return traveller_reject;
    }

    public void setTraveller_reject(int traveller_reject) {
        this.traveller_reject = traveller_reject;
    }
}
