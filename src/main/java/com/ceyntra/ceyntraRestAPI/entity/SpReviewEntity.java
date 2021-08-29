package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "traveller_review_to_sp")
public class SpReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;
    @Column(name = "traveller_id")
    private int user_id;
    private int sp_id;
    private String comment;
    private Timestamp timestamp;


    public SpReviewEntity() {
    }

    public SpReviewEntity(int user_id, int sp_id,  String comment, Timestamp timestamp) {

        this.user_id = user_id;
        this.sp_id = sp_id;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSp_id() {
        return sp_id;
    }

    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }



    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
