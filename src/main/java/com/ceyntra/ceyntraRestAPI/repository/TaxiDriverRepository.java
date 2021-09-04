package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaxiDriverRepository extends JpaRepository<TaxiDriverEntity, Integer> {
    @Query("SELECT a from TaxiDriverEntity a order by a.rating desc ")
    public List<TaxiDriverEntity> getAllTaxiDriversAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE TaxiDriverEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.taxi_driver_id = :#{#taxi_driver_id}")
    public int updateRatingAndVotes(@Param("rating") double rating, @Param("votes") int votes, @Param("taxi_driver_id") int taxi_driver_id );

}