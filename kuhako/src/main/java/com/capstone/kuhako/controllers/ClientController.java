package com.capstone.kuhako.controllers;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    ClientService clientService;

    // Create User
    @RequestMapping(value = "/client",method = RequestMethod.POST)
    public ResponseEntity<Object> createClient(@RequestBody Client client){
        clientService.createClient(client);
        return new ResponseEntity<>("Client Account created Successfully", HttpStatus.CREATED);
    }
    //  Get all User
    @GetMapping(value = "/client" )
    public ResponseEntity<Object> getUsername(@RequestHeader(value="Authorization") String stringToken) {
        return new ResponseEntity<>(clientService.getUsername(), HttpStatus.OK);
    }
    // Delete a U
    @RequestMapping (value = "/client/{clientid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteClient(@PathVariable Long clientid){
        return clientService.deleteClient(clientid);
    }
    // Update a post
    @RequestMapping (value = "/client/{clientid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateClient(@PathVariable Long clientid, @RequestBody Client client){
        return clientService.updateClient(clientid,client);
    }


    @PostMapping("/registerClient")
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException, UserException {
        String username = body.get("username");
        String password = body.get("password");
        String email = body.get("email");
        String fullName = body.get("fullName");
        String address = body.get("address");

        return clientService.registerClient(username, password, fullName, email, address);
    }

}
