package com.capstone.kuhako.models;

import com.capstone.kuhako.models.JoinModule.Contracts;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private Long client_id;

    @ManyToOne
    @JoinColumn(name="reseller_id")
    private Reseller reseller;

    @ManyToOne
    @JoinColumn(name="collector_id")
    private Collector collector;

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

   /* @OneToMany(mappedBy = "client")
    @JsonIgnore
    private Set<SendCollectors> sendCollectors;*/

    @OneToOne(mappedBy = "client")
    @JsonIgnore
    private Contracts contract;

    public Client() {
    }
    public Client(Reseller reseller, Collector collector, String username, String password, String fullName, String address, String email, Contracts contract) {
        this.reseller = reseller;
        this.collector = collector;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.contract = contract;
    }

    public Long getClient_id() {
        return client_id;
    }

//    public void setClient_id(Long client_id) {
//        this.client_id = client_id;
//        }


    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
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

   /* public Set<SendCollectors> getSendCollectors() {
        return sendCollectors;
    }

    public void setSendCollectors(Set<SendCollectors> sendCollectors) {
        this.sendCollectors = sendCollectors;
    }*/

    public Contracts getContract() {
        return contract;
    }

    public void setContract(Contracts contract) {
        this.contract = contract;
    }
}
