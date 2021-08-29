package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.SpRatingEntity;
import com.ceyntra.ceyntraRestAPI.model.TravellerSpId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpRatingRepository extends JpaRepository<SpRatingEntity, TravellerSpId> {
}
