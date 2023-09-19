package com.capstone.kuhako.models.ClientModules;

import com.capstone.kuhako.models.Client;

import javax.persistence.*;

@Entity
@Table(name = "payDues")
public class PayDues {
    @Id
    @GeneratedValue
    private int payDues_id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

   /* @Column
    private PaymentDues paymentDues;*/

    @OneToOne
    @JoinColumn(name="paymentDues_id", nullable = false)
    private PaymentDues paymentDues;

    @Column
    private double itemPrice;

    @Column
    private String referenceNumber;

    @Column
    private String paymentType;

    @Column
    private String transactionProof;

    public PayDues() {
    }
    public PayDues(Client client, PaymentDues paymentDues, double itemPrice, String referenceNumber, String paymentType, String transactionProof) {
        this.client = client;
        this.paymentDues = paymentDues;
        this.itemPrice = itemPrice;
        this.referenceNumber = referenceNumber;
        this.paymentType = paymentType;
        this.transactionProof = transactionProof;
    }

    public int getPayDues_id() {
        return payDues_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public PaymentDues getPaymentDues() {
        return paymentDues;
    }

    public void setPaymentDues(PaymentDues paymentDues) {
        this.paymentDues = paymentDues;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTransactionProof() {
        return transactionProof;
    }

    public void setTransactionProof(String transactionProof) {
        this.transactionProof = transactionProof;
    }
}
