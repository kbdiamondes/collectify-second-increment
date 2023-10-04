package com.capstone.kuhako.controllers;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    private ResellerRepository resellerRepository;

    // Create User
    @RequestMapping(value = "/client",method = RequestMethod.POST)
    public ResponseEntity<Object> createClient(@RequestBody Client client){
        clientService.createClient(client);
        return new ResponseEntity<>("Client Account created Successfully", HttpStatus.CREATED);
    }
    //  Get all User
    @RequestMapping(value = "/client" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUsername() {
        return new ResponseEntity<>(clientService.getUsername(), HttpStatus.OK);
    }

    // Get Specific User by ID and by Username
    @GetMapping("/client/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/client/findByUsername")
    public Optional<Client> findByUsername(@RequestParam String username) {
        return clientService.findByUsername(username);
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
}
