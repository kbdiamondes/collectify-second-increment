package com.capstone.kuhako.controllers.CollectorModuleController;


import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.User;
import com.capstone.kuhako.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class CollectAllDuePaymentsController {

    @Autowired
    UserService userService;

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }

    /*@RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }*/

    @RequestMapping(value = "/users/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable Long userid) {
        return userService.deleteUser(userid);
    }

    @RequestMapping(value="/users/{userid}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable Long userid, @RequestBody User user) {
        return userService.updateUser(userid, user);
    }

//    @RequestMapping(value="/users/register", method = RequestMethod.POST)
//    public ResponseEntity<Object> register(@RequestBody Map<String, String> body) throws UserException {
//        String username = body.get("username");
//
//        if (!userService.findByUsername(username).isEmpty()) {
//            throw new UserException("Username already exists.");
//        } else {
//            String password = body.get("password");
//
//            String encodedPassword = new BCryptPasswordEncoder().encode(password);
//
//            //User newUser = new User(username, encodedPassword);
//
//           // userService.createUser(newUser);
//
//            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
//        }
//    }
}