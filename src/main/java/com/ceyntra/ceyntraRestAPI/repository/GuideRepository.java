package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.GuideEntity;
import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface GuideRepository extends JpaRepository<GuideEntity, Integer> {

    @Query("SELECT a from GuideEntity a where a.is_accepted = 1 order by a.rating desc ")
    public List<GuideEntity> getAllGuidesAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE GuideEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.guide_id = :#{#guide_id}")
    public int updateRatingAndVotes(@Param("rating") double rating, @Param("votes") int votes, @Param("guide_id") int guide_id );
}
