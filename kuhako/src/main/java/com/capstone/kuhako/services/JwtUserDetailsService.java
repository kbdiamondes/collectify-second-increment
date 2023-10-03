package com.capstone.kuhako.services;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.capstone.kuhako.models.User;
import com.capstone.kuhako.repositories.ClientRepository;
import com.capstone.kuhako.repositories.CollectorRepository;
import com.capstone.kuhako.repositories.ResellerRepository;
import com.capstone.kuhako.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

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
