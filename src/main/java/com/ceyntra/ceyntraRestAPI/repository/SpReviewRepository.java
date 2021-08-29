package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlaceReviewEntity;
import com.ceyntra.ceyntraRestAPI.entity.SpReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpReviewRepository extends JpaRepository<SpReviewEntity, Integer> {
    @Query("SELECT a from SpReviewEntity a where  a.sp_id = :spId order by a.timestamp desc ")
    public List<SpReviewEntity> getAllReviews(@Param("spId") int spId);
}
