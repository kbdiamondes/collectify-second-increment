package com.capstone.kuhako.services;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ResellerServiceImpl implements ResellerService {
    @Autowired
    private ResellerRepository resellerRepository;

    @Autowired
    private ResellerService resellerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Find reseller  by reseller name
    // Create reseller
    public void createReseller(Reseller reseller){
        resellerRepository.save(reseller);
    }

    // Get all reseller
    public Iterable<Reseller> getUsername(){
        return resellerRepository.findAll();
    }

    // Delete reseller
    public ResponseEntity deleteReseller(Long id){
        resellerRepository.deleteById(id);
        return new ResponseEntity<>("User Deleted successfully", HttpStatus.OK);
    }

    // Update a reseller
    public ResponseEntity updateReseller(Long id , Reseller reseller){
        // Find the reseller  to update
        Reseller resellerForUpdate = resellerRepository.findById(id).get();
        // Updating the reseller name and password
        resellerForUpdate.setFullName(reseller.getFullName());
        resellerForUpdate.setAddress(reseller.getAddress());
        // Saving and Updating a reseller
        resellerRepository.save(resellerForUpdate);
        return new ResponseEntity<>("User updated Successfully",HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> findByUsername(String username) {
        Optional<Reseller> resellerOptional = Optional.ofNullable(resellerRepository.findByUsername(username));
        Map<Object, Object> userProperties = new HashMap<>();

        if (resellerOptional.isPresent()) {
            Reseller reseller = resellerOptional.get();
            userProperties.put("id", reseller.getReseller_id()); // Add more properties as needed
            userProperties.put("username", reseller.getUsername());
            // Add other user properties to the map
        }

        return userProperties;
    }

    @Override
    // Register a new client user
    public ResponseEntity<Object> registerReseller(String username, String password, String fullName,String email, String address) throws UserException {


        if (!resellerService.findByUsername(username).isEmpty()) {
            throw new UserException("Username already exists.");
        } else {
            String encodedPassword = passwordEncoder.encode(password);
            Reseller newUser = new Reseller(username, encodedPassword, fullName, email, address);
            resellerService.createReseller(newUser);
            return new ResponseEntity<>("Reseller registered successfully", HttpStatus.CREATED);
        }
    }
}
