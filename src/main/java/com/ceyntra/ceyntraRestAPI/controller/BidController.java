package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.BidDetailsEntity;
import com.ceyntra.ceyntraRestAPI.repository.BidDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BidController {

    @Autowired
    BidDetailsRepository bidDetailsRepository;
    @PostMapping("/addBidDetails")
    public int addBidDetails(@RequestBody BidDetailsEntity bidDetailsEntity){
        System.out.println(bidDetailsEntity.getNumber_of_passengers());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        bidDetailsEntity.setTimestamp(timestamp);
        bidDetailsEntity.setActive(1);
        bidDetailsEntity.setClose(0);

        BidDetailsEntity res = bidDetailsRepository.save(bidDetailsEntity);

        if(res.getDrop_location() != null){
            return 1;
        }
        return 0;
    }

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
}
