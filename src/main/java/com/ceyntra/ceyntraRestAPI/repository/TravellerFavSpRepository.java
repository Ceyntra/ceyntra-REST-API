package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerFavSpEntity;
import com.ceyntra.ceyntraRestAPI.model.TravellerSpId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravellerFavSpRepository extends JpaRepository<TravellerFavSpEntity, TravellerSpId> {
}
