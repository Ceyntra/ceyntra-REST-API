package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.BannedGuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannedGuideRepository extends JpaRepository<BannedGuideEntity, Integer> {
}
