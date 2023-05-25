package com.capstone.kuhako.models;

import com.capstone.kuhako.models.ResellerModule.SendCollectors;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "collector")
public class Collector {
    @Id
    @GeneratedValue
    private Long collector_id;

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

 /*   @OneToMany(mappedBy = "collector")
    @JsonIgnore
    private Set<SendCollectors> sendCollectors;*/

    public Collector() {
    }
    public Collector(Long collector_id, String username, String password, String fullName, String address, String email) {
        this.collector_id = collector_id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
    }

    public void setCollector_id(Long collector_id) {
        this.collector_id = collector_id;
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

    public Long getCollector_id() {
        return collector_id;
    }

 /*   public Set<SendCollectors> getSendCollectors() {
        return sendCollectors;
    }

    public void setSendCollectors(Set<SendCollectors> sendCollectors) {
        this.sendCollectors = sendCollectors;
    }*/
}
