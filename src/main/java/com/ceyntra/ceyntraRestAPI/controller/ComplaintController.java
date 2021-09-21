package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.ComplaintEntity;
import com.ceyntra.ceyntraRestAPI.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ComplaintController {

    @Autowired
    ComplaintRepository complaintRepository;

    @PostMapping("/addComplaint")
    public int addComplaint(@RequestBody ComplaintEntity complaintEntity){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        complaintEntity.setTimestamp(timestamp);
        complaintEntity.setIs_reviewed(0);

        ComplaintEntity complaintEntity1 = complaintRepository.save(complaintEntity);

        if(complaintEntity1.getDescription() != null){
            return 1;
        }else{
            return 0;
        }
    }

    @GetMapping("/getComplaint/{id}")
    public List<ComplaintEntity> getComplaints(@PathVariable("id") int id){
        List<ComplaintEntity> complainList = new ArrayList<>();
        List<ComplaintEntity> allComplains = complaintRepository.findAll();

        for(int i =0; i< allComplains.size(); i++){
            if(allComplains.get(i).getSp_id() == id){
                complainList.add(allComplains.get(i));
            }
        }

        return  complainList;


    }



}
