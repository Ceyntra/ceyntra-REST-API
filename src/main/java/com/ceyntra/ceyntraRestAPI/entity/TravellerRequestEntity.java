package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "traveller_request")
public class TravellerRequestEntity {

    @Id
    private int request_id;
    private int package_id;
    private int traveller_id;
    private Timestamp timestamp;
    private boolean is_accepted;
    private int sp_id;
    private int chatroom_id;
    private String package_type;

    public TravellerRequestEntity() {
    }

    public TravellerRequestEntity(int request_id, int package_id, int traveller_id, Timestamp timestamp, boolean is_accepted, int sp_id, int chatroom_id, String package_type) {
        this.request_id = request_id;
        this.package_id = package_id;
        this.traveller_id = traveller_id;
        this.timestamp = timestamp;
        this.is_accepted = is_accepted;
        this.sp_id = sp_id;
        this.chatroom_id = chatroom_id;
        this.package_type = package_type;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public int getTraveller_id() {
        return traveller_id;
    }

    public void setTraveller_id(int traveller_id) {
        this.traveller_id = traveller_id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }

    public int getChatroom_id() {
        return chatroom_id;
    }

    public void setChatroom_id(int chatroom_id) {
        this.chatroom_id = chatroom_id;
    }

    public String getPackage_type() {
        return package_type;
    }

    public void setPackage_type(String package_type) {
        this.package_type = package_type;
    }
}
