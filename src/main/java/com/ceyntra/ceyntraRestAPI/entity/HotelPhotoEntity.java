package com.ceyntra.ceyntraRestAPI.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel_photos")
public class HotelPhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int photo_id;
    private int hotel_id;
    private String photo;

    public HotelPhotoEntity() {
    }

    public HotelPhotoEntity(int photo_id, int hotel_id, String photo) {
        this.photo_id = photo_id;
        this.hotel_id = hotel_id;
        this.photo = photo;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
