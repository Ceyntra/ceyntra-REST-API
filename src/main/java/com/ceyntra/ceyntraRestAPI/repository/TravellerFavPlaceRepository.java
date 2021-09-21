package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerFavPlaceEntity;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TravellerFavPlaceRepository extends JpaRepository<TravellerFavPlaceEntity, UserPlaceId> {


    @Query("SELECT a from TravellerFavPlaceEntity a where a.user_id = :user_id ")
    public List<TravellerFavPlaceEntity> getFavPlaces(@Param("user_id") int user_id);

}
