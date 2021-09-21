package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.GuidePackageEntity;
import com.ceyntra.ceyntraRestAPI.entity.HotelPackageEntity;
import com.ceyntra.ceyntraRestAPI.entity.TaxiPackageEntity;
import com.ceyntra.ceyntraRestAPI.repository.GuidePackageRepository;
import com.ceyntra.ceyntraRestAPI.repository.HotelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuidePackageController {

    @Autowired
    private GuidePackageRepository guidePackageRepository;

    @GetMapping("/guidePackages/{guideId}")
    public List<GuidePackageEntity> getAllHotelPackagesByHotelID(@PathVariable("guideId") int guideId){
        return guidePackageRepository.getGuidePackageEntitiesByGuideId(guideId);
    }

    @PostMapping("/createGuidePackage")
    public GuidePackageEntity createTaxiPackage(@RequestBody GuidePackageEntity guidePackage){
        System.out.println(guidePackage.toString());
        return guidePackageRepository.save(guidePackage);
    }

    @PutMapping("/updateGuidePackage")
    public void updateTaxiPackage(@RequestBody GuidePackageEntity guidePackage){

        guidePackageRepository.save(guidePackage);
    }
    @DeleteMapping("deleteGuidePackage/{id}")
    public void deleteGuidePackage(@PathVariable int id){

        guidePackageRepository.deleteById(id);
    }


    @GetMapping("getGuidePackageCount/{id}")
    public int getGuidePackageCountByUserID(@PathVariable int id){

        return guidePackageRepository.countByGuideId(id);
    }
}
