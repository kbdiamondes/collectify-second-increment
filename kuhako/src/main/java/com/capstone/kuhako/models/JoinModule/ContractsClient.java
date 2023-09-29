package com.capstone.kuhako.models.JoinModule;

import javax.persistence.*;

@Entity
@Table(name = "contractsClient")
public class ContractsClient {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String itemName;
    @Column
    private double itemPrice;

    public ContractsClient() {
    }
    public ContractsClient(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
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
}
