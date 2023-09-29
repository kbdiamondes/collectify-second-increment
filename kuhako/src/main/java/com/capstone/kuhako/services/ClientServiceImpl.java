package com.capstone.kuhako.services;

import com.capstone.kuhako.config.WebSecurityConfig;
import com.capstone.kuhako.exceptions.UserException;
import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create Client
    public void createClient(Client client){
        clientRepository.save(client);
    }
    // Get all Client
    public Iterable<Client> getUsername(){
        return clientRepository.findAll();
    }

    // Delete Course
    public ResponseEntity deleteClient(Long id){
        clientRepository.deleteById(id);
        return new ResponseEntity<>("Client Deleted successful" +
                "ly", HttpStatus.OK);
    }
    // Update a Client
    public ResponseEntity updateClient(Long id, Client client){
        // Find the post to update
        Client clientForUpdate = clientRepository.findById(id).get();
        // Updating the tittle and content
        clientForUpdate.setFullName(client.getFullName());
        clientForUpdate.setAddress(client.getAddress());
        // Saving and Updating a post
        clientRepository.save(clientForUpdate);
        return new ResponseEntity<>("Client updated Successfully",HttpStatus.OK);
    }

    @Override
    public Map<Object, Object> findByUsername(String username) {
        Optional<Client> clientOptional = Optional.ofNullable(clientRepository.findByUsername(username));
        Map<Object, Object> userProperties = new HashMap<>();

        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            userProperties.put("id", client.getClient_id()); // Add more properties as needed
            userProperties.put("username", client.getUsername());
            // Add other user properties to the map
        }

        return userProperties;
    }

    @Override
    // Register a new client user
    public ResponseEntity<Object> registerClient(String username, String password, String fullName,String email, String address) throws UserException {


        if (!clientService.findByUsername(username).isEmpty()) {
            throw new UserException("Username already exists.");
        } else {
            String encodedPassword = passwordEncoder.encode(password);
            Client newUser = new Client(username, encodedPassword, fullName, email, address);
            clientService.createClient(newUser);
            return new ResponseEntity<>("Client registered successfully", HttpStatus.CREATED);
        }
    }

}
