package com.capstone.kuhako.config;
// JwtRequestFilter Code Flow Summary:
// "OncePerRequestFilter" is a class that guarantees a single execution per request received.
// This intercepts the incoming HTTP requests and checks if they contain a valid JWT token in the Authorization header.
// If a token is present, the filter attempts to validate it using the "JwtToken utility class".
// If the token is valid, the filter sets the authenticated user in the "SecurityContextHolder" and allows the request to proceed to the next filter or to the application controller.


import com.capstone.kuhako.services.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    //  This service is responsible for retrieving the user details from the database by username.
    private JwtUserDetailsService jwtUserDetailsService;

    // This is a utility class, injected into the filter through the constructor.
    // This class contains the JWT token validation logic.
    private final JwtToken jwtTokenUtil;

    // This constructor assigns the "JwtToken" instance to the "jwtTokenUtil" field of the "JwtRequestFilter" object, which allows the JwtRequestFilter to use methods defined in the JwtToken interface to interact with JWT tokens.
    // This pattern is known as dependency injection, where a dependent object (JwtRequestFilter) is provided with an instance of its required dependency (JwtToken) from the outside, rather than creating the dependency object within the class itself.
    public JwtRequestFilter(JwtToken jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    // doFilterInternal() method is the core method of the filter, which gets called for every incoming HTTP request.
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

        // gets the JWT token from the Authorization header of the incoming request and attempts to validate it using the JwtToken utility class.
        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;

        String jwtToken = null;

        // Checks if the token is present in the header upon sending the request.
        if (requestTokenHeader != null) {

            // if the a token is seen in the header it will be placed in the jwtToken variable and will be used to extract the username from the token claims.
            jwtToken = requestTokenHeader;


            // This will try to extract the username in the token, and if their is any exceptions encountered with the extraction it will log the following messages
            try {
                username = jwtTokenUtil.getUsernameFromToken(jwtToken);

            } catch (IllegalArgumentException e) {

                System.out.println("Unable to get JWT Token");
                System.out.println(e.toString());

            } catch (ExpiredJwtException e) {

                System.out.println("JWT Token has expired");

            }

        } else {

            logger.warn("JWT Token is incomplete");

        }

        // If the token is valid, the filter extracts the username from the token and checks if the user is already authenticated by checking the SecurityContextHolder.
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // "loadUserByUsername" method is invoked from the "jwtUserDetailsService" and load the"UserDetails" object associated with the extracted username from the token.
            UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);

            //  If the token is valid for the provided UserDetails object.
            //  If the token is valid, the method returns "true" indicating the user is authenticated.
            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {

                // If the token is valid, it creates an instance of the "UsernamePasswordAuthenticationToken" class, passing in the user details, a null password (since JWT tokens do not contain passwords), and the user's authorities.
                // The constructor takes three parameters:
                //1. userDetails - an object that implements the UserDetails interface which represents the user's details (such as username, password, and authorities).
                //
                //2. null - a placeholder for the user's password, which is not used in this case because the user is already authenticated via a JWT token.
                //
                //3.  userDetails.getAuthorities() - a collection of GrantedAuthority objects that represent the user's authorities (such as roles and permissions).
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(

                        userDetails, null, userDetails.getAuthorities());

                //  then used to authenticate the user's request.
                usernamePasswordAuthenticationToken

                        //  The "setDetails()" method is called on the "usernamePasswordAuthenticationToken" object with a new instance of "WebAuthenticationDetailsSource().buildDetails(request)".
                        // This sets additional details about the authentication request, such as the remote address, which can be useful for auditing or logging purposes.
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // This allows the current authenticated user to be retrieved and authorized on the other parts of the application.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        // This is a method call that is typically used in a servlet filter to pass the request and response objects to the next filter in the filter chain or next servlet that will handle the request.
        // In this scenario, the "chain.doFilter()" is invoked after user has been authenticated and the authenticated user details have been set.
        chain.doFilter(request, response);
    }
}

