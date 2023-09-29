package com.capstone.kuhako.services;

import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService; // Replace with the appropriate user service for each type (Client, Reseller, Collector)

    public ResponseEntity<Object> registerUser(String username, String password) throws UserException {
        if (!userService.findByUsername(username).isEmpty()) {
            throw new UserException("Username already exists.");
        } else {
            String encodedPassword = new BCryptPasswordEncoder().encode(password);
            User newUser = new User(username, encodedPassword);
            userService.createUser(newUser);
            return new ResponseEntity<>("Acccount has been created successfully", HttpStatus.CREATED);
        }
    }
}

