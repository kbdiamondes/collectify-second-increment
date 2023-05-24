package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Create Client
    public void createClient(Client client){
        clientRepository.save(client);
    }
    // Get all Client
    public Iterable<Client> getUsername(){
        return clientRepository.findAll();
    }

    // Delete Course
    public ResponseEntity deleteClient(int id){
        clientRepository.deleteById(id);
        return new ResponseEntity<>("Client Deleted successful" +
                "ly", HttpStatus.OK);
    }
    // Update a Client
    public ResponseEntity updateClient(int id, Client client){
        // Find the post to update
        Client clientForUpdate = clientRepository.findById(id).get();
        // Updating the tittle and content
        clientForUpdate.setFullName(client.getFullName());
        clientForUpdate.setAddress(client.getAddress());
        // Saving and Updating a post
        clientRepository.save(clientForUpdate);
        return new ResponseEntity<>("Client updated Successfully",HttpStatus.OK);
    }
}
