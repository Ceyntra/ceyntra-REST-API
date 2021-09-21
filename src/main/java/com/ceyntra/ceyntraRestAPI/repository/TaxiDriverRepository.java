package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TaxiDriverRepository extends JpaRepository<TaxiDriverEntity, Integer> {
    @Query("SELECT a from TaxiDriverEntity a order by a.rating desc ")
    public List<TaxiDriverEntity> getAllTaxiDriversAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE TaxiDriverEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.taxi_driver_id = :#{#taxi_driver_id}")
    public int updateRatingAndVotes(@Param("rating") double rating, @Param("votes") int votes, @Param("taxi_driver_id") int taxi_driver_id );

    @Transactional
    @Modifying
    @Query("UPDATE TaxiDriverEntity a SET a.profile_photo= :photo WHERE a.taxi_driver_id= :id")
    public int updatePhoto(@Param("photo") String photo, @Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE TaxiDriverEntity a SET a.driver_license= :license, a.first_name= :fname, a.last_name= :lname, a.per_km_price= :price WHERE a.taxi_driver_id= :id")
    public int updateTaxiDetails(@Param("license") String license, @Param("fname") String fname, @Param("lname") String lname, @Param("price") int price, @Param("id") int id);

    @Query("SELECT t from TaxiDriverEntity t where t.taxi_driver_id=:taxi_driver_id")
    TaxiDriverEntity getTaxiDriverEntityByTaxi_driver_id(@Param("taxi_driver_id") int taxi_driver_id);

    @Query("SELECT COUNT(a.taxi_driver_id) from TaxiDriverEntity a where a.is_accepted = 1")
    public int getDriverCount();

    @Query("SELECT COUNT(a.taxi_driver_id) from TaxiDriverEntity a where a.is_accepted = 0")
    public int getRequestCount();

    @Query(value = "SELECT first_name, last_name, rating, profile_photo FROM taxi_driver WHERE is_accepted=1 ORDER BY rating DESC LIMIT 5", nativeQuery = true)
    public List<Object> getTopFive();

    @Query("SELECT a from TaxiDriverEntity a WHERE a.is_accepted = 1 ORDER BY a.first_name ASC")
    public List<TaxiDriverEntity> getRegisteredDrivers();

    @Query("SELECT a from TaxiDriverEntity a WHERE a.is_accepted = 0")
    public List<TaxiDriverEntity> getNewRequests();

    @Transactional
    @Modifying
    @Query("UPDATE TaxiDriverEntity a SET a.is_accepted= 1 WHERE a.taxi_driver_id= :id")
    public int approveDriver(@Param("id") int id);

    @Query("SELECT a from TaxiDriverEntity a WHERE UPPER(a.district)=UPPER(:district) AND a.is_accepted=1 ORDER BY a.first_name ASC")
    public List<TaxiDriverEntity> getDistrictDrivers(@Param("district") String district);
}
