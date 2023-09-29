package com.capstone.kuhako.models.JoinModule;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;

import javax.persistence.*;

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
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    @Column
    private String itemName;
    @Column
    private double itemPrice;
    @Column
    private double totalAmountPaid;
    @Column
    private String paymentType;
    @Column
    private String specifications;
    @Column
    private boolean paymentStatus;

    public Contracts() {
    }
    public Contracts(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    public Contracts(Reseller reseller, Client client, Collector collector, String itemName, double itemPrice, double totalAmountPaid, String paymentType, String specifications, boolean paymentStatus) {
        this.reseller = reseller;
        this.client = client;
        this.collector = collector;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.totalAmountPaid = totalAmountPaid;
        this.paymentType = paymentType;
        this.specifications = specifications;
        this.paymentStatus = paymentStatus;
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

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
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
}
