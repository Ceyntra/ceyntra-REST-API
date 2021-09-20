package com.ceyntra.ceyntraRestAPI.controller;


import com.ceyntra.ceyntraRestAPI.entity.ComplaintEntity;
import com.ceyntra.ceyntraRestAPI.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

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

}
