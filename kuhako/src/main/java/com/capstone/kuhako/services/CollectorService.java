package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Collector;
import org.springframework.http.ResponseEntity;

public interface CollectorService {

    // Create Client
    void createCollector(Collector client);

    // Get Client
    Iterable<Collector> getUsername();

    // Delete Client
    ResponseEntity deleteCollector(int id);

    // Update a Client
    ResponseEntity updateCollector(int id, Collector collector);
}