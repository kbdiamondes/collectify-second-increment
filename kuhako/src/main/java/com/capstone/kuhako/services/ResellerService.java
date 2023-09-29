package com.capstone.kuhako.services;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Reseller;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ResellerService {
    // Create Client
    void createReseller(Reseller reseller);
    // Get Client
    Iterable<Reseller> getUsername();
    // Delete Client
    ResponseEntity deleteReseller(Long id);
    // Update a Client
    ResponseEntity updateReseller(Long id, Reseller reseller);

    Map<Object, Object> findByUsername(String username);

    //Register new reseller
    ResponseEntity<Object> registerReseller(String username, String password, String fullName, String email,  String address) throws UserException;
}
