package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TravellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;

public interface TravellerRepository extends JpaRepository<TravellerEntity, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE TravellerEntity a SET a.profile_photo= :photo WHERE a.userID= :id")
    public int updatePhoto(@Param("photo") String photo, @Param("id") int id);
//    @Query("UPDATE TravellerEntity SET profile_photo=?1 WHERE userID=?2")
//    public int updatePhoto(String photo, int id);
}
