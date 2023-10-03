package com.capstone.kuhako.config;
//The "JwtAuthenticate" class contains the "AuthenticationEntryPoint" is Spring Security's interface for running an authentication scheme.

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

// When a user tries to access a protected resource without proper authentication, an "AuthenticationException" is thrown and the "commence()" method is invoked to handle this exception
public class JwtAuthenticate implements AuthenticationEntryPoint, Serializable {

    // serialVersionUID serves as the "state" of a serializable object. This is used by Java in deserializing a
    // serialized object.
    //serialization is the process of transmitting information in a different data structure (ie. an object is
    // serialized into a string to be transmitted and gets deserialized back into an object when it reaches its
    // destination
    private static final long serialVersionUID = -5346081746532919847L;

    @Override
    // This will handle the authentication failures.
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         // AuthenticationException is a class in Spring Security that contains all exceptions related to an Authentication object being invalid
                         AuthenticationException authException) throws IOException {
        // This will send a HTTP error response with a 401 status code with an "Unauthorized" message to the client.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");

    }
}
