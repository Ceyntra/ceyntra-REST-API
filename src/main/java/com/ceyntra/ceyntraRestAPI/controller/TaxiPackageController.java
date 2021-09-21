package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TaxiPackageEntity;
import com.ceyntra.ceyntraRestAPI.repository.TaxiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class TaxiPackageController {

    @Autowired
    private TaxiPackageRepository taxiPackageRepository;


    @PostMapping("/createTaxiPackage")
    public TaxiPackageEntity createTaxiPackage(@RequestBody TaxiPackageEntity taxiPackage){

        return taxiPackageRepository.save(taxiPackage);
    }


    @GetMapping("/taxiPackages/{taxiDriverId}")
    public List<TaxiPackageEntity> getAllTaxiPackagesByTaxiID(@PathVariable("taxiDriverId") int taxiDriverId){

        return taxiPackageRepository.getTaxiPackageEntitiesByTaxiDriverId(taxiDriverId);

    }

    //Author:isuru
    @GetMapping("getPackageDetails/{id}")
    public List<TaxiPackageEntity> getPackageDetails(@PathVariable int id){
        List<TaxiPackageEntity> packageList=taxiPackageRepository.getAllPackages(id);
        return packageList;
    }

    @PutMapping("/updateTaxiPackage")
    public void updateTaxiPackage(@RequestBody TaxiPackageEntity taxiPackage){

        taxiPackageRepository.save(taxiPackage);
    }
    @DeleteMapping("deleteTaxiPackage/{id}")
    public void deleteTaxiPackage(@PathVariable int id){

        taxiPackageRepository.deleteById(id);
    }

    @GetMapping("getTaxiPackageCount/{id}")
    public int getTAxiPackageCountByUserID(@PathVariable int id){

        return taxiPackageRepository.countByTaxiDriverId(id);
    }

}
