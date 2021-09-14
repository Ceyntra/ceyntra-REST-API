package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.BidDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface BidDetailsRepository extends JpaRepository<BidDetailsEntity, Integer> {

    @Query("SELECT a from BidDetailsEntity a where a.active = :active and a.traveller_id = :traveller_id")
    public List<BidDetailsEntity> getActivateBidDetails(@Param("active") int active, @Param("traveller_id") int traveller_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidDetailsEntity a SET a.active = :#{#active}, a.close= :#{#close} WHERE a.bid_id = :#{#bid_id}")
    public int closeBid(@Param("active") int active, @Param("close") int close, @Param("bid_id") int bid_id);

    @Transactional
    @Modifying
    @Query("UPDATE BidDetailsEntity a SET a.active = :#{#active}, a.close= :#{#close} WHERE a.bid_id = :#{#bid_id}")
    public int finishBid(@Param("active") int active, @Param("close") int close, @Param("bid_id") int bid_id);

    @Query("SELECT a from BidDetailsEntity a where a.active = :active and a.traveller_id = :traveller_id and a.close = :close ")
    public List<BidDetailsEntity> getHistoryBidList(@Param("active") int active, @Param("traveller_id") int traveller_id, @Param("close") int close);
}
