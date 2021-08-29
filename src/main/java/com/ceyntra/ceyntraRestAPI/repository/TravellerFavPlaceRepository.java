package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerFavPlaceEntity;
import com.ceyntra.ceyntraRestAPI.model.UserPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravellerFavPlaceRepository extends JpaRepository<TravellerFavPlaceEntity, UserPlaceId> {


}
