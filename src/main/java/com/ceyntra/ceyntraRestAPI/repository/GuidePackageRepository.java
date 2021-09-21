package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.GuidePackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuidePackageRepository extends JpaRepository<GuidePackageEntity,Integer> {

    List<GuidePackageEntity> getGuidePackageEntitiesByGuideId(int guideId);

    int countByGuideId(int guideId);

}
