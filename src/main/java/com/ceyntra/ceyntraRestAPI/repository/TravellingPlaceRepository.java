package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellingPlaceRepository extends JpaRepository<TravellingPlaceEntity, Integer> {

    @Query("SELECT a from TravellingPlaceEntity a where a.is_accepted = 1 order by a.rating desc ")
    public List<TravellingPlaceEntity> getPlacesAndSortByRating();
}
