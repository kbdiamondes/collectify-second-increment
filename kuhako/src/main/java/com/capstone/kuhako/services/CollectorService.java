package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Collector;
import org.springframework.http.ResponseEntity;

public interface CollectorService {

    // Create Client
    void createCollector(Long resellerId, Collector client);

    // Get Client
    Iterable<Collector> getUsername();

    // Delete Client
    ResponseEntity deleteCollector(Long id);

    // Update a Client
    ResponseEntity updateCollector(Long id, Collector collector);
}