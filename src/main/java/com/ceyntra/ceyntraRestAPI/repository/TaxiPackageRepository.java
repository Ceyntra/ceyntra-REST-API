package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TaxiPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiPackageRepository extends JpaRepository<TaxiPackageEntity,Integer> {


    List<TaxiPackageEntity> getTaxiPackageEntitiesByTaxiDriverId(int taxiDriverId);

    //Author:isuru
    @Query("SELECT a FROM TaxiPackageEntity a WHERE a.taxiDriverId= :id")
    public List<TaxiPackageEntity> getAllPackages(@Param("id") int id);

    int countByTaxiDriverId(int driverId);

}
