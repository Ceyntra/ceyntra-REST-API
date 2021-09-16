package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.BidAcceptedDetailsEntity;
import com.ceyntra.ceyntraRestAPI.entity.BidDetailsEntity;
import com.ceyntra.ceyntraRestAPI.entity.TaxiDriverEntity;
import com.ceyntra.ceyntraRestAPI.entity.UserEntity;
import com.ceyntra.ceyntraRestAPI.model.BidAndSpId;
import com.ceyntra.ceyntraRestAPI.model.CoordinatesModel;
import com.ceyntra.ceyntraRestAPI.repository.BidAcceptedDeailsRepository;
import com.ceyntra.ceyntraRestAPI.repository.BidDetailsRepository;
import com.ceyntra.ceyntraRestAPI.repository.TaxiDriverRepository;
import com.ceyntra.ceyntraRestAPI.repository.UserRepository;
import net.bytebuddy.utility.JavaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Registration;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BidController {

    @Autowired
    BidDetailsRepository bidDetailsRepository;
    @Autowired
    TaxiDriverRepository taxiDriverRepository;
    @Autowired
    BidAcceptedDeailsRepository bidAcceptedDeailsRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/addBidDetails")
    public int addBidDetails(@RequestBody BidDetailsEntity bidDetailsEntity){
        System.out.println(bidDetailsEntity.getNumber_of_passengers());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        bidDetailsEntity.setTimestamp(timestamp);
        bidDetailsEntity.setActive(1);
        bidDetailsEntity.setClose(0);

        BidDetailsEntity res = bidDetailsRepository.save(bidDetailsEntity);


//get all taxi driver list according to the location
        List<TaxiDriverEntity> currentLocationAvailableTaxis = new ArrayList<>();
        List<TaxiDriverEntity> allTaxiDriverList = taxiDriverRepository.getAllTaxiDriversAndSortByRating();

//        int distance = 0;
//
//
//        CoordinatesModel anotherPlaceCoordinates = new CoordinatesModel(bidDetailsEntity.getCurrent_latitude(), bidDetailsEntity.getCurrent_longitude());
//
//        for (int i = 0; i< allTaxiDriverList.size(); i++){
//            anotherPlaceCoordinates.setLatitude(allTaxiDriverList.get(i).getWorking_latitude());
//            anotherPlaceCoordinates.setLongitude(allTaxiDriverList.get(i).getWorking_longitude());
//
//            distance = travellingPlaceService.calculateDistanceBetweenTwoPlaces(currentPlaceCoordinates, anotherPlaceCoordinates);
//
//            if(distance < 100){
//                currentLocationAvailableTaxis.add(allTaxiDriverList.get(i));
//            }
//
//
//
//        }



        if(res.getDrop_location() != null){

            for(int i = 0; i< allTaxiDriverList.size(); i++){
                System.out.println(allTaxiDriverList.get(i).getTaxi_driver_id());
                BidAcceptedDetailsEntity bidAcceptedDetailsEntity1 = new BidAcceptedDetailsEntity(res.getBid_id(), allTaxiDriverList.get(i).getTaxi_driver_id(), 0,0,0,0,1, "");
                BidAcceptedDetailsEntity res2 = bidAcceptedDeailsRepository.save(bidAcceptedDetailsEntity1);
            }
            return 1;
        }
        return 0;
    }


//    List<BidAcceptedDetailsEntity> list2 = new ArrayList<>();
//            for(int i = 0; i< allTaxiDriverList.size(); i++){
//        System.out.println(allTaxiDriverList.get(i).getTaxi_driver_id());
//        BidAcceptedDetailsEntity bidAcceptedDetailsEntity1 = new BidAcceptedDetailsEntity(res.getBid_id(), allTaxiDriverList.get(i).getTaxi_driver_id(), 0,0,0,0);
//        list2.add(bidAcceptedDetailsEntity1);
//    }
//
//            bidAcceptedDeailsRepository.saveAll(list2);

    @GetMapping("/getActiveBidDetails/{id}")
    public BidDetailsEntity getActiveBidDetails(@PathVariable("id") int id){
        List<BidDetailsEntity> bidDetailsEntityList = bidDetailsRepository.getActivateBidDetails(1,id);
//        System.out.println(bidDetailsEntityList.get(0).getPick_up_time());

        System.out.println("helloooo");

        if(bidDetailsEntityList.isEmpty()){
            return new BidDetailsEntity();
        }
        else{
            return bidDetailsEntityList.get(0);
        }

    }

    @GetMapping("/getBidHistory/{id}")
    public List<BidDetailsEntity> getBidHistory(@PathVariable("id") int id){
        List<BidDetailsEntity> bidDetailsEntityList = bidDetailsRepository.getHistoryBidList(0,id, 0);
//        System.out.println(bidDetailsEntityList.get(0).getPick_up_time());

       return bidDetailsEntityList;

    }

    @GetMapping("/getActiveBidDetailsForAddNewBid/{id}")
    public int getActiveBidDetailsForAddNewBid(@PathVariable("id") int id){
        List<BidDetailsEntity> bidDetailsEntityList = bidDetailsRepository.getActivateBidDetails(1,id);
//        System.out.println(bidDetailsEntityList.get(0).getPick_up_time());

        if(bidDetailsEntityList.isEmpty()){
            return 0;
        }
        else{
            return 1;
        }

    }


    @GetMapping("/closeBid/{id}")
    public int closeBid(@PathVariable("id") int id){
        int updateState = bidDetailsRepository.closeBid(0,1,id);
        System.out.println(updateState);
        return updateState;

    }

    @GetMapping("/finishBid/{id}")
    public int finishBid(@PathVariable("id") int id){
        int updateState = bidDetailsRepository.finishBid(0,0,id);
        System.out.println(updateState);
        return updateState;

    }

    @GetMapping("/getAvailableBidsForTaxiDriver/{id}")
    public List<BidDetailsEntity> getAvailableBidsForTaxiDriver(@PathVariable("id") int id){
        List<BidDetailsEntity> bidDetailsEntityList = new ArrayList<>();
        List<BidAcceptedDetailsEntity> bidAcceptedDetailsEntityList = bidAcceptedDeailsRepository.getActivateBidDetails(id);
        for(int i =0; i< bidAcceptedDetailsEntityList.size(); i++){
            bidDetailsEntityList.add(bidDetailsRepository.findById(bidAcceptedDetailsEntityList.get(i).getBid_id()).get());
        }
        return bidDetailsEntityList;

    }

    @PostMapping("/taxiDriverRejectBid")
    public int taxiDriverRejectBid(@RequestBody BidAndSpId bidAndSpId){
        int updateState = bidAcceptedDeailsRepository.updateTaxiDriverRejectBid(bidAndSpId.getBid_id(), bidAndSpId.getTaxi_driver_id());
        return updateState;
    }

    @PostMapping("/taxiDriverAcceptBid/{comment}")
    public int taxiDriverAcceptBid(@RequestBody BidAndSpId bidAndSpId, @PathVariable("comment") String comment){
//        System.out.println(comment);

        int updateState = bidAcceptedDeailsRepository.updateTaxiDriverAcceptBid(comment, bidAndSpId.getBid_id(), bidAndSpId.getTaxi_driver_id());
        return updateState;
    }

    @PostMapping("/travellerAcceptBidResponse")
    public int travellerAcceptBidResponse(@RequestBody BidAndSpId bidAndSpId){
//        System.out.println(comment);
        int updateState = bidAcceptedDeailsRepository.updateTravellerAcceptBid(1,bidAndSpId.getBid_id(), bidAndSpId.getTaxi_driver_id());
        int updateState2 = 0;
        if(updateState == 1){
           updateState2 =   bidAcceptedDeailsRepository.deactivateBid(bidAndSpId.getBid_id());
        }

        return updateState2;
    }


    @GetMapping("/getBidResponses/{id}")
    public List<HashMap<String, Object>>  getBidResponses(@PathVariable int id){
        List<BidAcceptedDetailsEntity> bidAcceptedDetailsEntityList = bidAcceptedDeailsRepository.getBidResponses(id);
        List<HashMap<String, Object>> taxiDriverMap = new ArrayList<>();

        for(int i =0; i< bidAcceptedDetailsEntityList.size(); i++){
            TaxiDriverEntity taxiDriverDetails = taxiDriverRepository.findById(bidAcceptedDetailsEntityList.get(i).getTaxi_driver_id()).get();

            HashMap<String, Object> details = new HashMap<>();
            details.put("taxiDriverDetails", taxiDriverDetails);
            details.put("taxiDriverNote", bidAcceptedDetailsEntityList.get(i).getComment());
           taxiDriverMap.add(details);
        }

        return taxiDriverMap;
    }

    @GetMapping("/findCAcceptedTaxiDriver/{id}")
    public  HashMap<String, Object>  findCAcceptedTaxiDriver(@PathVariable int id){
        List<BidAcceptedDetailsEntity> list = bidAcceptedDeailsRepository.findCAcceptedTaxiDriver(id);
        int userId = list.get(0).getTaxi_driver_id();
        UserEntity userDetails = userRepository.findById(userId).get();
        TaxiDriverEntity taxiDriverDetails = taxiDriverRepository.findById(userId).get();

        HashMap<String, Object> details = new HashMap<>();

        details.put("mobileNumber", userDetails.getTelephone());
        details.put("taxiDriverDetails", taxiDriverDetails);


        return details;
    }




}
