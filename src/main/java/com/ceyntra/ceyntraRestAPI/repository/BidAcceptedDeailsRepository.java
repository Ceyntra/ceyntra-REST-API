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

    @Query("SELECT a from BidAcceptedDetailsEntity a where a.taxi_driver_id = :taxi_driver_id and a.taxi_driver_accept = 0 and a.taxi_driver_reject=0 and a.traveller_accept = 0 and a.traveller_reject=0 and a.activeState = 1 and a.available = 1")
    public List<BidAcceptedDetailsEntity> getActivateBidDetails(@Param("taxi_driver_id") int taxi_driver_id);

    @Query("SELECT a from BidAcceptedDetailsEntity a where a.bid_id = :bid_id and a.taxi_driver_accept = 1 and a.taxi_driver_reject=0 and a.traveller_accept = 0 and a.traveller_reject=0 and a.activeState = 1")
    public List<BidAcceptedDetailsEntity> getBidResponses(@Param("bid_id") int bid_id);

    @Query("SELECT a from BidAcceptedDetailsEntity a where a.bid_id = :bid_id and a.taxi_driver_accept = 1 and a.taxi_driver_reject=0 and a.traveller_accept = 1 and a.traveller_reject=0 ")
    public List<BidAcceptedDetailsEntity> findCAcceptedTaxiDriver(@Param("bid_id") int bid_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidAcceptedDetailsEntity a SET a.taxi_driver_reject = 1 WHERE a.bid_id = :#{#bid_id} and a.taxi_driver_id = :#{#taxi_driver_id}")
    public int updateTaxiDriverRejectBid(@Param("bid_id") int bid_id, @Param("taxi_driver_id") int taxi_driver_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidAcceptedDetailsEntity a SET a.traveller_accept = :#{#active} WHERE a.bid_id = :#{#bid_id} and a.taxi_driver_id = :#{#taxi_driver_id}")
    public int updateTravellerAcceptBid(@Param("active") int active,@Param("bid_id") int bid_id, @Param("taxi_driver_id") int taxi_driver_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidAcceptedDetailsEntity a SET a.traveller_reject = :#{#active} WHERE a.bid_id = :#{#bid_id} and a.taxi_driver_id = :#{#taxi_driver_id}")
    public int updateTravellerRejectBid(@Param("active") int active,@Param("bid_id") int bid_id, @Param("taxi_driver_id") int taxi_driver_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidAcceptedDetailsEntity a SET a.activeState = 0 WHERE a.bid_id = :#{#bid_id}")
    public int deactivateBid(@Param("bid_id") int bid_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidAcceptedDetailsEntity a SET a.available = 0 WHERE a.bid_id = :#{#bid_id}")
    public int notAvailableBid(@Param("bid_id") int bid_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidAcceptedDetailsEntity a SET a.taxi_driver_accept = 1, a.comment = :#{#comment} WHERE a.bid_id = :#{#bid_id} and a.taxi_driver_id = :#{#taxi_driver_id}")
    public int updateTaxiDriverAcceptBid(@Param("comment") String comment,@Param("bid_id") int bid_id,  @Param("taxi_driver_id") int taxi_driver_id);
}
