package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlaceRatingEntity;
import com.ceyntra.ceyntraRestAPI.entity.SpRatingEntity;
import com.ceyntra.ceyntraRestAPI.model.TravellerSpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SpRatingRepository extends JpaRepository<SpRatingEntity, TravellerSpId> {
    @Transactional
    @Modifying
    @Query("UPDATE SpRatingEntity a SET a.rating = :#{#rating} WHERE a.sp_id = :#{#sp_id} and a.traveller_id = :#{#traveller_id}")
    public int updateRating(@Param("rating") double rating, @Param("sp_id") int sp_id, @Param("traveller_id") int traveller_id );

    @Query("SELECT a from SpRatingEntity a where  a.sp_id = :sp_id ")
    public List<SpRatingEntity> geSpRatingBySpId(@Param("sp_id") int sp_id);
}
