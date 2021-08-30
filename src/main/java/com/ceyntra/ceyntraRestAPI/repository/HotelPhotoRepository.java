package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.HotelPhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelPhotoRepository extends JpaRepository<HotelPhotoEntity, Integer> {
    @Query("SELECT a.photo from HotelPhotoEntity a where  a.hotel_id = :hotelId ")
    public List<String> getAllPhotosOfHotel(@Param("hotelId") int hotelId);
}
