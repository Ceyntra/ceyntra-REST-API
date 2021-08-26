package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlaceRatingEntity;
import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PlaceRatingRepository extends JpaRepository<PlaceRatingEntity, UserPlaceId> {

    @Transactional
    @Modifying
    @Query("UPDATE PlaceRatingEntity a SET a.rating = :#{#rating} WHERE a.user_id = :#{#userId} and a.place_id = :#{#placeId}")
    public int updateRating(@Param("rating") double rating, @Param("userId") int userId, @Param("placeId") int placeId );

    @Query("SELECT a from PlaceRatingEntity a where  a.place_id = :placeId ")
    public List<PlaceRatingEntity> gePlaceRatingByPlaceId(@Param("placeId") int placeId);
}
