package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.BidAcceptedDetailsEntity;
import com.ceyntra.ceyntraRestAPI.entity.BidDetailsEntity;
import com.ceyntra.ceyntraRestAPI.model.BidAcceptedId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BidAcceptedDeailsRepository extends JpaRepository<BidAcceptedDetailsEntity, BidAcceptedId> {

    @Query("SELECT a from BidAcceptedDetailsEntity a where a.taxi_driver_id = :taxi_driver_id and a.taxi_driver_accept = 0 and a.taxi_driver_reject=0 and a.traveller_accept = 0 and a.traveller_reject=0 and a.activeState = 1")
    public List<BidAcceptedDetailsEntity> getActivateBidDetails(@Param("taxi_driver_id") int taxi_driver_id);

    @Transactional
    @Modifying
    @Query("UPDATE UserEntity a SET a.isLoggedIn = :#{#isLoggedIn} WHERE a.userID = :#{#userId}")
    public int updateUserLoggedInStatus(@Param("isLoggedIn") int isLoggedIn, @Param("userId") int userId);
}
