package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerFavEntity;
import com.ceyntra.ceyntraRestAPI.model.TravellerFavPlaceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravellerFavPlaceRepository extends JpaRepository<TravellerFavEntity, TravellerFavPlaceId> {


}
