package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.model.TravellingPlaceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellingPlaceRepository extends JpaRepository<TravellingPlaceModel, Integer> {

    @Query("SELECT a from TravellingPlaceModel a order by a.rating desc ")
    public List<TravellingPlaceModel> getPlacesAndSortByRating();
}
