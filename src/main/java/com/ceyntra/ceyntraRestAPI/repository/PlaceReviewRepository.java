package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceReviewRepository extends JpaRepository<PlaceReviewEntity, Integer> {

    @Query("SELECT a from PlaceReviewEntity a where  a.place_id = :placeId order by a.timestamp desc ")
    public List<PlaceReviewEntity> getAllReviews( @Param("placeId") int placeId);
}
