package com.capstone.kuhako.controllers;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.services.CollectorService;
import com.capstone.kuhako.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class CollectorController {

    @Autowired
    CollectorService collectorService;


    @Autowired
    private RegistrationService registrationService;

    // Create User
    @RequestMapping(value = "/collector",method = RequestMethod.POST)
    public ResponseEntity<Object> createCollector(@RequestBody Collector collector){
        collectorService.createCollector(collector);
        return new ResponseEntity<>("Collector Account created Successfully", HttpStatus.CREATED);
    }
    //  Get all User
    @RequestMapping(value = "/collector" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUsername(@RequestHeader(value="Authorization") String stringToken) {
        return new ResponseEntity<>(collectorService.getUsername(), HttpStatus.OK);
    }
    // Delete a U
    @RequestMapping (value = "/collector/{collectorid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long collectorid){
        return collectorService.deleteCollector(collectorid);
    }
    // Update a post
    @RequestMapping (value = "/collector/{collectorid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCollector(@PathVariable Long collectorid, @RequestBody Collector collector){
        return collectorService.updateCollector(collectorid,collector);
    }

    @PostMapping("/registerCollector")
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException, UserException {
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        String fullName = body.get("fullName");
        String address = body.get("address");

        return collectorService.registerCollector(username, password, fullName, email, address);
    }
}
