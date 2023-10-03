package com.capstone.kuhako.config;


import com.capstone.kuhako.controllers.AuthController;
import com.capstone.kuhako.models.User;
import com.capstone.kuhako.repositories.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtToken implements Serializable {

    //to get token from application.properties
    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private UserRepository userRepository;

    private static final long serialVersionUID = -1972806378937325850L;

    //Time duration in seconds that the token can be used
    public static final long JWT_TOKEN_VALIDITY = 5*60*60; //5 hours

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    //This generates the JWT by setting the claims, subject, issues at, expiration and signing the token with a secret
    private String doGenerateToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY * 1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        // Check the user's roles and add appropriate roles to the claims
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
            claims.put("role", "CLIENT");
        } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_COLLECTOR"))) {
            claims.put("role", "COLLECTOR");
        } else if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_RESELLER"))) {
            claims.put("role", "RESELLER");
        }


        logger.debug("Claims: " + claims);
        System.out.println("Claims: " + claims);
        return doGenerateToken(claims, userDetails.getUsername());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        final String role = (String) getClaimFromToken(token, claims -> claims.get("role"));

        // Check if the token's username and role match the UserDetails
        return username.equals(userDetails.getUsername()) && roleMatchesUser(userDetails, role) && !isTokenExpired(token);
    }

    private boolean roleMatchesUser(UserDetails userDetails, String role) {
        // Check if the user's roles match the role in the token
        if (userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_" + role))) {
            return true;
        }
        return false;
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public String getUsernameFromToken(String token) {
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("JWT token is null or empty");
        }
        return getClaimFromToken(token, Claims::getSubject);
    }


    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);

        return expiration.before(new Date());
    }

}
