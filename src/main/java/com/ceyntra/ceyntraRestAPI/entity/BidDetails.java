package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bid_details")
public class BidDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int bid_id;
    private int traveller_id;
    private String pick_up_time;
    private String pick_up_location;
    private String drop_location;
    private Timestamp timestamp;
    private int traveller_price;
    private int number_of_passengers;
    private String traveller_note;
    private int active;
    private int close;

    public BidDetails() {
    }

    public BidDetails(int traveller_id, String pick_up_time, String pick_up_location, String drop_location, Timestamp timestamp, int traveller_price, int number_of_passengers, String traveller_note, int active, int close) {
        this.traveller_id = traveller_id;
        this.pick_up_time = pick_up_time;
        this.pick_up_location = pick_up_location;
        this.drop_location = drop_location;
        this.timestamp = timestamp;
        this.traveller_price = traveller_price;
        this.number_of_passengers = number_of_passengers;
        this.traveller_note = traveller_note;
        this.active = active;
        this.close = close;
    }

    public int getBid_id() {
        return bid_id;
    }

    public void setBid_id(int bid_id) {
        this.bid_id = bid_id;
    }

    public int getTraveller_id() {
        return traveller_id;
    }

    public void setTraveller_id(int traveller_id) {
        this.traveller_id = traveller_id;
    }

    public String getPick_up_time() {
        return pick_up_time;
    }

    public void setPick_up_time(String pick_up_time) {
        this.pick_up_time = pick_up_time;
    }

    public String getPick_up_location() {
        return pick_up_location;
    }

    public void setPick_up_location(String pick_up_location) {
        this.pick_up_location = pick_up_location;
    }

    public String getDrop_location() {
        return drop_location;
    }

    public void setDrop_location(String drop_location) {
        this.drop_location = drop_location;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getTraveller_price() {
        return traveller_price;
    }

    public void setTraveller_price(int traveller_price) {
        this.traveller_price = traveller_price;
    }

    public int getNumber_of_passengers() {
        return number_of_passengers;
    }

    public void setNumber_of_passengers(int number_of_passengers) {
        this.number_of_passengers = number_of_passengers;
    }

    public String getTraveller_note() {
        return traveller_note;
    }

    public void setTraveller_note(String traveller_note) {
        this.traveller_note = traveller_note;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getClose() {
        return close;
    }

    public void setClose(int close) {
        this.close = close;
    }
}
