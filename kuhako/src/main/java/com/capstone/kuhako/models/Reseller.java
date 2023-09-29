package com.capstone.kuhako.models;

import com.capstone.kuhako.models.JoinModule.Contracts;
import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "reseller")
public class Reseller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reseller_id;

    @OneToMany(mappedBy = "reseller", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Collector> collectors;

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

    @OneToMany(mappedBy = "reseller")
    @JsonIgnore
    private Set<Contracts> contracts;

    @OneToMany(mappedBy = "reseller")
    @JsonIgnore
    private Set<SendCollectors> sendCollectors;

    public Reseller() {
    }

    public Reseller(Set<Collector> collectors, String username, String password, String fullName, String address, String email, Set<Contracts> contracts, Set<SendCollectors> sendCollectors) {
        this.collectors = collectors;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.contracts = contracts;
        this.sendCollectors = sendCollectors;
    }
    //    public void setReseller_id(Long reseller_id) {
//        this.reseller_id = reseller_id;
//    }

    public Set<Collector> getCollectors() {
        return collectors;
    }

    public void setCollectors(Set<Collector> collectors) {
        this.collectors = collectors;
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

    public Long getReseller_id() {
        return reseller_id;
    }

    public Set<SendCollectors> getSendCollectors() {
        return sendCollectors;
    }

    public void setSendCollectors(Set<SendCollectors> sendCollectors) {
        this.sendCollectors = sendCollectors;
    }

    public Set<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contracts> contracts) {
        this.contracts = contracts;
    }
}
