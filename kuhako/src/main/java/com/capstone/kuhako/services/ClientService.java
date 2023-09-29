package com.capstone.kuhako.services;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Client;
import org.springframework.http.ResponseEntity;

import java.util.Map;


public interface ClientService {
    // Create Client
    void createClient(Client client);
    // Get Client
    Iterable<Client> getUsername();
    // Delete Client
    ResponseEntity deleteClient(Long id);
    // Update a Client
    ResponseEntity updateClient(Long id, Client Client);

    Map<Object, Object> findByUsername(String username);

    // Register a new client user
    ResponseEntity<Object> registerClient(String username, String password, String fullName, String email,  String address) throws UserException;

}