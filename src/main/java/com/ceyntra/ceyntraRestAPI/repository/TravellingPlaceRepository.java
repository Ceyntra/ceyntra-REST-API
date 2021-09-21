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

    @Query("SELECT a from TravellingPlaceEntity a where a.is_accepted = 0 ")
    public List<TravellingPlaceEntity> getNotAcceptedPlaces();

    @Query("SELECT a from TravellingPlaceEntity a where a.place_name = :place ")
    public List<TravellingPlaceEntity> getPlaceByPlaceName(@Param("place") String place);

//    @Query("delete from TravellingPlaceEntity a  where a.place_id = :place_id ")
//    public List<TravellingPlaceEntity> delete(@Param("place_id") int place_id);

    @Transactional
    @Modifying
    @Query("UPDATE TravellingPlaceEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.place_id = :#{#placeId}")
    public int updateRatingAndVotes(@Param("rating") double rating,@Param("votes") int votes, @Param("placeId") int placeId );

    @Transactional
    @Modifying
    @Query("UPDATE TravellingPlaceEntity a SET a.is_accepted = :#{#is_accepted} where a.place_id = :#{#placeId}")
    public int approvePlace(@Param("is_accepted") int is_accepted, @Param("placeId") int placeId );
}
