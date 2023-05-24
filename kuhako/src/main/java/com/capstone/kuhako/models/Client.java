package com.capstone.kuhako.models;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private int client_id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private String address;

    @Column
    private String email;

    public Client() {
        }
    public int getClient_id() {
        return client_id;
        }
    public Client(int client_id, String username, String password, String fullName, String address, String email) {
            this.client_id = client_id;
            this.username = username;
            this.password = password;
            this.fullName = fullName;
            this.address = address;
            this.email = email;
        }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
        }

    public String getUsername() {
        return username;
        }

    public void setUsername(String username) {
        this.username = username;
        }

    public String getPassword() {
        return password;
        }

    public void setPassword(String password) {
        this.password = password;
        }

    public String getFullName() {
        return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }



    }
