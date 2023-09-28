package com.capstone.kuhako.controllers;


import com.capstone.kuhako.config.JwtToken;
import com.capstone.kuhako.models.JwtRequest;
import com.capstone.kuhako.models.JwtResponse;
import com.capstone.kuhako.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    // This takes an argument of "JwtRequest" object as the "request body" and returns a "ResponseEntity" object as the "HTTP response".
    // This handles "authentication requests" and generates a "JWT token" as a response.
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        // This authenticates the user by passing username and password from the JwtRequest object to the "authenticationManager.authenticate" method.
        // This will throw an exception if the authentication fails.
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());



        // loads the user details from the "jwtUserDetailsService" using the provided username from the "JwtRequest" object
        final UserDetails userDetails = jwtUserDetailsService

                .loadUserByUsername(authenticationRequest.getUsername());

        // This method generates a JWT token using the user details obtained from the "jwtUserDetailsService".
        final String token = jwtToken.generateToken(userDetails);

        // Log successful authentication
        logger.info("User authenticated successfully: " + authenticationRequest.getUsername());

        // Log the generated token
        logger.info("Generated JWT token: " + token);

        //This sends a response back to the client using the "JwtResponse" object containing the generated JWT token.
        return ResponseEntity.ok(new JwtResponse(token));

    }

    // This is a helper method that authenticates the user by calling "authenticationManager.authenticate" method with the provided username and password. It catches and throws exceptions for disabled users or invalid credentials.
    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        // User is ban from the system
        catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }
        // User provided wrong credentials
        catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }

}
