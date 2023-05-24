package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Client;
import org.springframework.http.ResponseEntity;



public interface ClientService {
    // Create Client
    void createClient(Client client);
    // Get Client
    Iterable<Client> getUsername();
    // Delete Client
    ResponseEntity deleteClient(int id);
    // Update a Client
    ResponseEntity updateClient(int id, Client Client);
}