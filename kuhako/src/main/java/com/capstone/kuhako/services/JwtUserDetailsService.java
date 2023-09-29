package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.repositories.ClientRepository;
import com.capstone.kuhako.repositories.CollectorRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CollectorRepository collectorRepository;

    @Autowired
    private ResellerRepository resellerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check if the username exists in Client repository
        Client client = clientRepository.findByUsername(username);
        if (client != null) {
            // Load client details and roles/authorities here
            // Example roles: ROLE_CLIENT
            return new org.springframework.security.core.userdetails.User(
                    client.getUsername(),
                    client.getPassword(),
                    getAuthorities("ROLE_CLIENT")
            );
        }

        // Check if the username exists in Collector repository
        Collector collector = collectorRepository.findByUsername(username);
        if (collector != null) {
            // Load collector details and roles/authorities here
            // Example roles: ROLE_COLLECTOR
            return new org.springframework.security.core.userdetails.User(
                    collector.getUsername(),
                    collector.getPassword(),
                    getAuthorities("ROLE_COLLECTOR")
            );
        }

        // Check if the username exists in Reseller repository
        Reseller reseller = resellerRepository.findByUsername(username);
        if (reseller != null) {
            // Load reseller details and roles/authorities here
            // Example roles: ROLE_RESELLER
            return new org.springframework.security.core.userdetails.User(
                    reseller.getUsername(),
                    reseller.getPassword(),
                    getAuthorities("ROLE_RESELLER")
            );
        }

        throw new UsernameNotFoundException("User not found");
    }

    // Helper method to create a list of SimpleGrantedAuthority based on roles
    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }
}

/*
@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CollectorRepository collectorRepository;

    @Autowired
    private ResellerRepository resellerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check if the username exists in Client, Collector, or Reseller repositories
        Client client = clientRepository.findByUsername(username);
        if (client != null) {
            return new org.springframework.security.core.userdetails.User(
                    client.getUsername(),
                    client.getPassword(),
                    // Add client roles/authorities here if applicable
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_CLIENT"))
            );
        }

        Collector collector = collectorRepository.findByUsername(username);
        if (collector != null) {
            return new org.springframework.security.core.userdetails.User(
                    collector.getUsername(),
                    collector.getPassword(),
                    // Add collector roles/authorities here if applicable
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_COLLECTOR"))
            );
        }

        Reseller reseller = resellerRepository.findByUsername(username);
        if (reseller != null) {
            return new org.springframework.security.core.userdetails.User(
                    reseller.getUsername(),
                    reseller.getPassword(),
                    // Add reseller roles/authorities here if applicable
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_RESELLER"))
            );
        }

        throw new UsernameNotFoundException("User not found");
    }
}
*/