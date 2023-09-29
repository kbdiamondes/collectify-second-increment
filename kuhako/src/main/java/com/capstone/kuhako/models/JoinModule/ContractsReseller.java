package com.capstone.kuhako.models.JoinModule;

import javax.persistence.*;

@Entity
@Table(name = "contractsReseller")
public class ContractsReseller {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;
    @Column
    private String itemName;
    @Column
    private double itemPrice;
    @Column
    private String paymentType;

    public ContractsReseller() {
    }
    public ContractsReseller(String username, String itemName, double itemPrice, String paymentType) {
        this.username = username;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.paymentType = paymentType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
