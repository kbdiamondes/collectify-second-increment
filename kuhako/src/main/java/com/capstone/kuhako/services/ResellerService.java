package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Reseller;
import org.springframework.http.ResponseEntity;

public interface ResellerService {
    // Create Client
    void createReseller(Reseller reseller);
    // Get Client
    Iterable<Reseller> getUsername();
    // Delete Client
    ResponseEntity deleteReseller(int id);
    // Update a Client
    ResponseEntity updateReseller(int id, Reseller reseller);
}
