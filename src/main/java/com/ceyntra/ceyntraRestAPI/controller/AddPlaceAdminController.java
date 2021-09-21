package com.ceyntra.ceyntraRestAPI.controller;

import com.ceyntra.ceyntraRestAPI.entity.TravellingPlaceEntity;
import com.ceyntra.ceyntraRestAPI.entity.TravellingPlacePhoto;
import com.ceyntra.ceyntraRestAPI.model.AdminPlaceAddModel;
import com.ceyntra.ceyntraRestAPI.repository.TravellingPlacePhotoRepository;
import com.ceyntra.ceyntraRestAPI.repository.TravellingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class AddPlaceAdminController {

    @Autowired
    private TravellingPlaceRepository travellingPlaceRepository;

    @Autowired
    private TravellingPlacePhotoRepository travellingPlacePhotoRepository;

    @PostMapping("/addPlaceByAdmin")
    public ResponseEntity<TravellingPlaceEntity> savePlaces(@RequestBody AdminPlaceAddModel placeAddModel){

        System.out.println(placeAddModel.toString());

        //Added to place table
        TravellingPlaceEntity travellingPlaceEntity=new TravellingPlaceEntity(0,placeAddModel.getPlace_name(),placeAddModel.getDescription(),placeAddModel.getLatitude(),placeAddModel.getLongitude(),1,0,0,placeAddModel.getImage1(),1,null,placeAddModel.getDistrict());
        TravellingPlaceEntity savedPlace= travellingPlaceRepository.save(travellingPlaceEntity);



        //Create 3 photo entity
        TravellingPlacePhoto travellingPlacePhoto1=new TravellingPlacePhoto(0,travellingPlaceEntity.getPlace_id(),placeAddModel.getImage1());
        travellingPlacePhotoRepository.save(travellingPlacePhoto1);

        TravellingPlacePhoto travellingPlacePhoto2=new TravellingPlacePhoto(0,travellingPlaceEntity.getPlace_id(),placeAddModel.getImage2());
        travellingPlacePhotoRepository.save(travellingPlacePhoto2);

        TravellingPlacePhoto travellingPlacePhoto3=new TravellingPlacePhoto(0,travellingPlaceEntity.getPlace_id(),placeAddModel.getImage3());
        travellingPlacePhotoRepository.save(travellingPlacePhoto3);

        return ResponseEntity.ok(savedPlace);
    }
}
