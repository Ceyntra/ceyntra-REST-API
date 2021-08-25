package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.PlaceRatingEntity;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRatingRepository extends JpaRepository<PlaceRatingEntity, UserPlaceId> {


}
