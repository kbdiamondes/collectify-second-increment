package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Collector;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CollectorService {

    // Create Client
    void createCollector(Collector client);

    // Get Client
    Iterable<Collector> getUsername();

    // Delete Client
    ResponseEntity deleteCollector(Long id);

    // Update a Client
    ResponseEntity updateCollector(Long id, Collector collector);


    Optional<Collector> getCollectorById(Long id);

    Optional<Collector> findByUsername(String username);
}