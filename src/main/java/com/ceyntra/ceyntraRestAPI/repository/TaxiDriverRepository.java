package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaxiDriverRepository extends JpaRepository<TaxiDriverEntity, Integer> {
    @Query("SELECT a from TaxiDriverEntity a order by a.rating desc ")
    public List<TaxiDriverEntity> getAllTaxiDriversAndSortByRating();
}
