package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerFavPlaceEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellerFavSpEntity;
import com.ceyntra.ceyntraRestAPI.model.TravellerSpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TravellerFavSpRepository extends JpaRepository<TravellerFavSpEntity, TravellerSpId> {

    @Query("SELECT a from TravellerFavSpEntity a where a.traveller_id = :traveller_id ")
    public List<TravellerFavSpEntity> getFavTaxi(@Param("traveller_id") int traveller_id);
}
