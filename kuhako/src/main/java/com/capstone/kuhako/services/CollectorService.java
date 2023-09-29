package com.capstone.kuhako.services;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Collector;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CollectorService {

    // Create Client
    void createCollector(Collector client);

    // Get Client
    Iterable<Collector> getUsername();

    // Delete Client
    ResponseEntity deleteCollector(Long id);

    // Update a Client
    ResponseEntity updateCollector(Long id, Collector collector);

    Map<Object, Object> findByUsername(String username);

    // Register a new client user
    ResponseEntity<Object> registerCollector(String username, String password, String fullName, String email,  String address) throws UserException;
}