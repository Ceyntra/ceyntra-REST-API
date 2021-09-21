package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.BannedHotelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedHotelsRepository extends JpaRepository<BannedHotelsEntity, Integer> {
}
