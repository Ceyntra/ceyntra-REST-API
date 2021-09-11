package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TaxiPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxiPackageRepository extends JpaRepository<TaxiPackageEntity,Integer> {

    List<TaxiPackageEntity> getTaxiPackageEntitiesByTaxiDriverId(int taxiDriverId);

}
