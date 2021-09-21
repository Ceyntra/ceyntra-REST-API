package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.BannedTaxiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedTaxiRepository extends JpaRepository<BannedTaxiEntity, Integer> {
}
