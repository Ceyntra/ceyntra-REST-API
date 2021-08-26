package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlacePhotoEntity;
import com.ceyntra.ceyntraRestAPI.entity.PlaceRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlacePhotoRepository extends JpaRepository<PlacePhotoEntity, Integer> {

    @Query("SELECT a.photo from PlacePhotoEntity a where  a.place_id = :placeId ")
    public List<String> getAllPhotosOfPlace(@Param("placeId") int placeId);
}
