package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravellerRequestRepository extends JpaRepository<TravellerRequestEntity,Integer> {

    @Query("FROM TravellerRequestEntity t WHERE t.traveller_id=:traveller_id")
    List<TravellerRequestEntity> getTravellerRequestEntitiesByTraveller_id(@Param("traveller_id") int traveller_id);

}
