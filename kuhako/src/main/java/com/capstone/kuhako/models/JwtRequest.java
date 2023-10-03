package com.capstone.kuhako.models;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    // Properties
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;

    private String password;

    // Constructors
    // Default constructors
    public JwtRequest(){
    }

    // Parametrized Constructors
    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    // Getters and Setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

