package com.capstone.kuhako.controllers;

import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.services.CollectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class CollectorController {
    @Autowired
    CollectorService collectorService;
    @Autowired
    private ResellerRepository resellerRepository;

    // Create User
    @RequestMapping(value = "/collector/{resellerId}", method = RequestMethod.POST)
    public ResponseEntity<Object> createCollector(@PathVariable Long resellerId, @RequestBody Collector collector) {
        Reseller reseller = resellerRepository.findById(resellerId).orElse(null);
        if (reseller != null) {
            collectorService.createCollector(resellerId, collector);
            return new ResponseEntity<>("Collector Account created Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Reseller does not exist", HttpStatus.NOT_FOUND);
        }
    }

    //  Get all User
    @RequestMapping(value = "/collector" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUsername() {
        return new ResponseEntity<>(collectorService.getUsername(), HttpStatus.OK);
    }
    // Delete a User
    @RequestMapping (value = "/collector/{collectorid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long collectorid){
        return collectorService.deleteCollector(collectorid);
    }
    // Update a post
    @RequestMapping (value = "/collector/{collectorid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCollector(@PathVariable Long collectorid, @RequestBody Collector collector){
        return collectorService.updateCollector(collectorid,collector);
    }
}
