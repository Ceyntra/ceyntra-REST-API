package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TaxiPackageEntity;
import com.ceyntra.ceyntraRestAPI.repository.TaxiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaxiPackageController {

    @Autowired
    private TaxiPackageRepository taxiPackageRepository;


    @PostMapping("/createTaxiPackage")
    public TaxiPackageEntity createTaxiPackage(@RequestBody TaxiPackageEntity taxiPackage){

        return taxiPackageRepository.save(taxiPackage);
    }

    @GetMapping("getPackageDetails/{id}")
    public List<TaxiPackageEntity> getPackageDetails(@PathVariable int id){
        List<TaxiPackageEntity> packageList=taxiPackageRepository.getAllPackages(id);
        return packageList;
    }

}
