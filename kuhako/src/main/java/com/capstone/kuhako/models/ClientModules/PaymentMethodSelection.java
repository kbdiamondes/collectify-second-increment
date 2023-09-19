package com.capstone.kuhako.models.ClientModules;

import com.capstone.kuhako.models.Client;

import javax.persistence.*;

@Entity
@Table(name = "paymentMethodSelection")
public class PaymentMethodSelection {
    @Id
    @GeneratedValue
    private int paymentMethodSelection_id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;
    @Column
    private String purchaseMethod;

    @Column
    private String itemName;

    @Column
    private String itemPrice;

    @Column
    private String itemSpecs;

    @Column
    private double installmentAmount;

    public PaymentMethodSelection() {
    }
    public PaymentMethodSelection(String purchaseMethod, String itemName, String itemPrice, String itemSpecs, double installmentAmount) {
        this.purchaseMethod = purchaseMethod;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemSpecs = itemSpecs;
        this.installmentAmount = installmentAmount;
    }

    public int getPaymentMethodSelection_id() {
        return paymentMethodSelection_id;
    }

    public String getPurchaseMethod() {
        return purchaseMethod;
    }

    public void setPurchaseMethod(String purchaseMethod) {
        this.purchaseMethod = purchaseMethod;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemSpecs() {
        return itemSpecs;
    }

    public void setItemSpecs(String itemSpecs) {
        this.itemSpecs = itemSpecs;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }
}
