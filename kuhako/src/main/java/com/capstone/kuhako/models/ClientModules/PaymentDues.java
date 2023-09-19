package com.capstone.kuhako.models.ClientModules;

import com.capstone.kuhako.models.Client;

import javax.persistence.*;

@Entity
@Table(name = "paymentDues")
public class PaymentDues {
    @Id
    @GeneratedValue
    private int paymentDues_id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
    @Column
    private String itemName;

    @Column
    private double requiredCollectible;

    @Column
    private boolean dueStatus;

    public PaymentDues() {
    }

    public PaymentDues(String itemName, double requiredCollectible, boolean dueStatus) {
        this.itemName = itemName;
        this.requiredCollectible = requiredCollectible;
        this.dueStatus = dueStatus;
    }

    public int getPaymentDues_id() {
        return paymentDues_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getRequiredCollectible() {
        return requiredCollectible;
    }

    public void setRequiredCollectible(double requiredCollectible) {
        this.requiredCollectible = requiredCollectible;
    }

    public boolean isDueStatus() {
        return dueStatus;
    }

    public void setDueStatus(boolean dueStatus) {
        this.dueStatus = dueStatus;
    }
}
