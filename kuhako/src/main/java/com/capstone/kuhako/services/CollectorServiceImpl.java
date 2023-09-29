package com.capstone.kuhako.services;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.repositories.CollectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CollectorServiceImpl implements CollectorService{
    @Autowired
    private CollectorRepository collectorRepository;

    @Autowired
    private CollectorService collectorService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create a Collector
    public void createCollector(Collector collector){
        collectorRepository.save(collector);
    }
    // Get all Collector
    public Iterable<Collector> getUsername(){
        return collectorRepository.findAll();
    }
    // Delete Collector

    public ResponseEntity deleteCollector(Long id){
        collectorRepository.deleteById(id);
        return new ResponseEntity<>("Collector Deleted successfully", HttpStatus.OK);
    }
    public ResponseEntity updateCollector(Long id, Collector collector){
        // Find the user to update
        Collector collectorForUpdate = collectorRepository.findById(id).get();
        // Updating the username and password
        collectorForUpdate .setFullName(collector.getFullName());
        collectorForUpdate .setAddress(collector.getAddress());
        // Saving and Updating a user
        collectorRepository.save(collectorForUpdate );
        return new ResponseEntity<>("Collector updated Successfully",HttpStatus.OK);
    }


    @Override
    public Map<Object, Object> findByUsername(String username) {
        Optional<Collector> collectorOptional = Optional.ofNullable(collectorRepository.findByUsername(username));
        Map<Object, Object> userProperties = new HashMap<>();

        if (collectorOptional.isPresent()) {
            Collector collector = collectorOptional.get();
            userProperties.put("id", collector.getCollector_id()); // Add more properties as needed
            userProperties.put("username", collector.getUsername());
            // Add other user properties to the map
        }

        return userProperties;
    }

    @Override
    // Register a new client user
    public ResponseEntity<Object> registerCollector(String username, String password, String fullName,String email, String address) throws UserException {


        if (!collectorService.findByUsername(username).isEmpty()) {
            throw new UserException("Username already exists.");
        } else {
            String encodedPassword = passwordEncoder.encode(password);
            Collector newUser = new Collector(username, encodedPassword, fullName, email, address);
            collectorService.createCollector(newUser);
            return new ResponseEntity<>("Collector registered successfully", HttpStatus.CREATED);
        }
    }

}
