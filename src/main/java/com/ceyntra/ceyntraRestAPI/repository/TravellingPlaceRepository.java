package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TravellingPlaceRepository extends JpaRepository<TravellingPlaceEntity, Integer> {

    @Query("SELECT a from TravellingPlaceEntity a where a.is_accepted = 1 order by a.rating desc ")
    public List<TravellingPlaceEntity> getPlacesAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE TravellingPlaceEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.place_id = :#{#placeId}")
    public int updateRatingAndVotes(@Param("rating") double rating,@Param("votes") int votes, @Param("placeId") int placeId );
}
