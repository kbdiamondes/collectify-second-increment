package com.capstone.kuhako.controllers;


import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.User;
import com.capstone.kuhako.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
// Enables cross origin request via @CrossOrigin.
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    // Create User
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<Object> createPost(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>("User created Successfully", HttpStatus.CREATED);
    }
    //  Get all User
    @RequestMapping(value = "/users" , method = RequestMethod.GET)
    public ResponseEntity<Object> getUsername() {
        return new ResponseEntity<>(userService.getUsername(), HttpStatus.OK);
    }
    // Delete a U
    @RequestMapping (value = "/users/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable Long userid){
        return userService.deleteUser(userid);
    }
    // Update a post
    @RequestMapping (value = "/users/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable Long userid, @RequestBody User user){
        return userService.updateUser(userid,user);
    }

    // User registration
    @RequestMapping(value="/users/register", method = RequestMethod.POST)
    // Register method takes a" request body as a Map of key-value pairs", where the keys are strings and the values are strings. It also throws a "UserException" in case of an error, which is a "custom exception".
    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException {
        // This retrieves the value associated with the "username" key from the request body "Map" and assigns it to a String variable called "username".
        String username = body.get("username");

        // check if the user provided "username" exists in the database, if the user exists, it throws a UserException with the message "Username already exists."
        if (!userService.findByUsername(username).isEmpty()) {
            throw new UserException("Username already exists.");
        }
        // if username doesn't exists, it will proceed on creating of the client.
        else {
            // This retrieves the value associated with the "password" key from the request body "Map" and assigns it to a String variable called "password".
            String password = body.get("password");

            //This encrypts the password using the BCryptPasswordEncode, and store it to the "encodedPassword" variable.
            String encodedPassword = new BCryptPasswordEncoder().encode(password);

            // Instantiates the User model to create a new user
            User newUser = new User(username, encodedPassword);

            // saves in the "newUser" in the database.
            userService.createUser(newUser);

            // Sends a "User registered successfully" message as the response body and an HTTP status code of 201.
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        }
    }
}
