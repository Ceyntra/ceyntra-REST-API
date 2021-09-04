package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
    @Query("SELECT a from HotelEntity a where a.is_accepted = 1 order by a.rating desc ")
    public List<HotelEntity> getAllHotelsAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE HotelEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.hotel_id = :#{#hotel_id}")
    public int updateRatingAndVotes(@Param("rating") double rating, @Param("votes") int votes, @Param("hotel_id") int hotel_id );
}