package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "travelling_place_photo")
public class TravellingPlacePhoto {

    @Id
    private int photo_id;
    private int place_id;
    private String photo;

    public TravellingPlacePhoto() {
    }

    public TravellingPlacePhoto(int photo_id, int place_id, String photo) {
        this.photo_id = photo_id;
        this.place_id = place_id;
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "TravellingPlacePhoto{" +
                "photo_id=" + photo_id +
                ", place_id=" + place_id +
                ", photo='" + photo + '\'' +
                '}';
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
