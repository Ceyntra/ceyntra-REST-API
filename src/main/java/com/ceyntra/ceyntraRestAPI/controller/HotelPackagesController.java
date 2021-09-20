package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.GuidePackageEntity;
import com.ceyntra.ceyntraRestAPI.entity.HotelPackageEntity;
import com.ceyntra.ceyntraRestAPI.entity.TaxiPackageEntity;
import com.ceyntra.ceyntraRestAPI.repository.HotelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelPackagesController {

    @Autowired
    private HotelPackageRepository hotelPackageRepository;

    @GetMapping("/hotelPackages/{hotelId}")
    public List<HotelPackageEntity> getAllHotelPackagesByHotelID(@PathVariable("hotelId") int hotelId){
        return hotelPackageRepository.getHotelPackageEntitiesByHotelId(hotelId);
    }

    @PostMapping("/createHotelPackage")
    public HotelPackageEntity createTaxiPackage(@RequestBody HotelPackageEntity hotelPackage){

        System.out.println(hotelPackage.toString());



        return hotelPackageRepository.save(hotelPackage);
    }

    @PutMapping("/updateHotelPackage")
    public void updateHotelPackage(@RequestBody HotelPackageEntity hotelPackage){

        hotelPackageRepository.save(hotelPackage);
    }

    @DeleteMapping("deleteHotelPackage/{id}")
    public void deleteHotelPackage(@PathVariable int id){

        hotelPackageRepository.deleteById(id);
    }
}
