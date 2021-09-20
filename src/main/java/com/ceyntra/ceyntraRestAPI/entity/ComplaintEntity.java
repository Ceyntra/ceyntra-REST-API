package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "complaint")
public class ComplaintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int complaint_id;
    private String description;
    private Timestamp timestamp;
    private int traveller_id;
    private int sp_id;
    private int is_reviewed;

    public ComplaintEntity() {
    }

    public ComplaintEntity(int complaint_id, String description, Timestamp timestamp, int traveller_id, int sp_id, int is_reviewed) {
        this.complaint_id = complaint_id;
        this.description = description;
        this.timestamp = timestamp;
        this.traveller_id = traveller_id;
        this.sp_id = sp_id;
        this.is_reviewed = is_reviewed;
    }


    public int getComplaint_id() {
        return complaint_id;
    }

    public void setComplaint_id(int complaint_id) {
        this.complaint_id = complaint_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    public int getIs_reviewed() {
        return is_reviewed;
    }

    public void setIs_reviewed(int is_reviewed) {
        this.is_reviewed = is_reviewed;
    }
}
