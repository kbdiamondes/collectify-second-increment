package com.capstone.kuhako.controllers;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.services.RegistrationService;
import com.capstone.kuhako.services.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ResellerController {
    @Autowired
    ResellerService resellerService;

    @Autowired
    private RegistrationService registrationService;


    // Create User
    @RequestMapping(value = "/reseller",method = RequestMethod.POST)
    public ResponseEntity<Object> createCollector(@RequestBody Reseller reseller){
        resellerService.createReseller(reseller);
        return new ResponseEntity<>("Reseller Account created Successfully", HttpStatus.CREATED);
    }
    //  Get all User
    @RequestMapping(value = "/reseller" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUsername(@RequestHeader(value="Authorization") String stringToken) {
        return new ResponseEntity<>(resellerService.getUsername(), HttpStatus.OK);
    }
    // Delete a U
    @RequestMapping (value = "/reseller/{resellerid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long resellerid){
        return resellerService.deleteReseller(resellerid);
    }
    // Update a post
    @RequestMapping (value = "/resel/{resellerid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCollector(@PathVariable Long resellerid, @RequestBody Reseller reseller){
        return resellerService.updateReseller(resellerid,reseller);
    }

    @PostMapping("/registerReseller")
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException, UserException {
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        String fullName = body.get("fullName");
        String address = body.get("address");
        return resellerService.registerReseller(username, password, fullName, email, address);
    }
}
