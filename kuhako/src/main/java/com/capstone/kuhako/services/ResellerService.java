package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Reseller;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ResellerService {
    // Create Client
    void createReseller(Reseller reseller);
    // Get Client
    Iterable<Reseller> getUsername();
    // Delete Client
    ResponseEntity deleteReseller(Long id);
    // Update a Client
    ResponseEntity updateReseller(Long id, Reseller reseller);

    ResponseEntity assignCollectorToClient(Long resellerId, Long collectorId, Long clientId);


    Optional<Reseller> getResellerById(Long id);

    Optional<Reseller> findByUsername(String username);


}
