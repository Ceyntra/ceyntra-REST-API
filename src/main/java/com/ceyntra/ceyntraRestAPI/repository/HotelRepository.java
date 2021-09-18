package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.entity.HotelEntity;
import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {
    @Query("SELECT a from HotelEntity a where a.is_accepted = 1 order by a.rating desc ")
    public List<HotelEntity> getAllHotelsAndSortByRating();

    @Transactional
    @Modifying
    @Query("UPDATE HotelEntity a SET a.rating = :#{#rating}, a.number_of_votes = :#{#votes} where a.hotel_id = :#{#hotel_id}")
    public int updateRatingAndVotes(@Param("rating") double rating, @Param("votes") int votes, @Param("hotel_id") int hotel_id );

    @Transactional
    @Modifying
    @Query("UPDATE HotelEntity a SET a.profile_photo= :photo WHERE a.hotel_id= :id")
    public int updatePhoto(@Param("photo") String photo, @Param("id") int id);


    @Query("SELECT h from HotelEntity h where h.hotel_id=:hotel_id")
    HotelEntity getHotelEntityByHotel_id(@Param("hotel_id") int hotel_id);

    @Transactional
    @Modifying
    @Query("UPDATE HotelEntity a SET a.name= :name, a.registration_number= :registration, a.description= :description WHERE a.hotel_id= :id")
    public int updateHotelDetails(@Param("name") String name, @Param("registration") String registration, @Param("description") String description, @Param("id") int id);

    @Query("SELECT COUNT(a.hotel_id) from HotelEntity a where a.is_accepted = 1")
    public int getCount();

    @Query("SELECT a from HotelEntity a WHERE a.is_accepted = 1 ORDER BY a.name ASC")
    public List<HotelEntity> getRegisteredHotels();

    @Query("SELECT a from HotelEntity a WHERE UPPER(a.district)=UPPER(:district) AND a.is_accepted=1 ORDER BY a.name ASC")
    public List<HotelEntity> getDistrictHotels(@Param("district") String district);
}
