package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceReviewRepository extends JpaRepository<PlaceReviewEntity, UserPlaceId> {

    @Query("SELECT a from PlaceReviewEntity a where a.user_id = :userId and a.place_id = :placeId ")
    public List<PlaceReviewEntity> getAllReviews(@Param("userId") int userId, @Param("placeId") int placeId);
}
