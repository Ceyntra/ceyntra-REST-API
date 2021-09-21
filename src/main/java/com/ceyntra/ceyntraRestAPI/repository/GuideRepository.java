package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.GuideEntity;
import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<GuideEntity, Integer> {

    @Query("SELECT a from GuideEntity a where a.is_accepted = 1 order by a.rating desc ")
    public List<GuideEntity> getAllGuidesAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE GuideEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.guide_id = :#{#guide_id}")
    public int updateRatingAndVotes(@Param("rating") double rating, @Param("votes") int votes, @Param("guide_id") int guide_id );

    @Transactional
    @Modifying
    @Query("UPDATE GuideEntity a SET a.profile_photo= :photo WHERE a.guide_id= :id")
    public int updatePhoto(@Param("photo") String photo, @Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE GuideEntity a SET a.nic= :nic, a.first_name= :fname, a.last_name= :lname, a.per_day_price= :price, a.description= :description, a.vehicle_state= :state WHERE a.guide_id= :id")
    public int updateGuideDetails(@Param("nic") String nic, @Param("fname") String fname, @Param("lname") String lname, @Param("price") int price, @Param("description") String description, @Param("state") String state, @Param("id") int id);

    @Query("SELECT g from GuideEntity g where g.guide_id=:guide_id")
    GuideEntity getGuideEntityByGuide_id( @Param("guide_id") int guide_id);

    @Query("SELECT g.rating FROM GuideEntity g  WHERE g.guide_id=:id")
    double getRatingByGuideID(@Param("id")  int id);
}
