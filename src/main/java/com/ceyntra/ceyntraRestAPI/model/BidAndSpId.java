package com.ceyntra.ceyntraRestAPI.model;

public class BidAndSpId {

    private int bid_id;
    private int taxi_driver_id;

    public BidAndSpId(int bid_id, int taxi_driver_id) {
        this.bid_id = bid_id;
        this.taxi_driver_id = taxi_driver_id;
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
}
