package com.capstone.kuhako.models.JoinModule;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contracts_id;

    @ManyToOne
    @JoinColumn(name="reseller_id", nullable = false)
    private Reseller reseller;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name="collector_id")
    private Collector collector;

    @Column
    private String itemName;
    @Column
    private double itemPrice;
    @Column
    private double debtRemaining;
    @Column
    private String paymentType;
    @Column
    private String specifications;
    @Column
    private boolean paymentStatus;

    @OneToMany(mappedBy = "contracts")
    @JsonIgnore
    private Set<Transactions> transactions;

    public Contracts() {
    }

    public Contracts(Reseller reseller, Client client, Collector collector, String itemName, double itemPrice, double debtRemaining, String paymentType, String specifications, boolean paymentStatus, Set<Transactions> transactions) {
        this.reseller = reseller;
        this.client = client;
        this.collector = collector;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.debtRemaining = debtRemaining;
        this.paymentType = paymentType;
        this.specifications = specifications;
        this.paymentStatus = paymentStatus;
        this.transactions = transactions;
    }

    public Long getContracts_id() {
        return contracts_id;
    }

//    public void setContracts_id(Long contracts_id) {
//        this.contracts_id = contracts_id;
//    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getDebtRemaining() {
        return debtRemaining;
    }

    public void setDebtRemaining(double debtRemaining) {
        this.debtRemaining = debtRemaining;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Set<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transactions> transactions) {
        this.transactions = transactions;
    }
}
