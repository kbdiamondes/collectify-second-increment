package com.capstone.kuhako.models.ClientModules;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.CollectorModules.CollectPayments;

import javax.persistence.*;

public class ClientPaymentRecords {
    @Id
    @GeneratedValue
    private int clientPaymentRecords_id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @Column
    private PayDues payDues;

    @Column
    private CollectPayments collectPayments;

    public ClientPaymentRecords() {
    }

    public ClientPaymentRecords(Client client, PayDues payDues, CollectPayments collectPayments) {
        this.client = client;
        this.payDues = payDues;
        this.collectPayments = collectPayments;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getClientPaymentRecords_id() {
        return clientPaymentRecords_id;
    }

    public PayDues getPayDues() {
        return payDues;
    }

    public void setPayDues(PayDues payDues) {
        this.payDues = payDues;
    }

    public CollectPayments getCollectPayments() {
        return collectPayments;
    }

    public void setCollectPayments(CollectPayments collectPayments) {
        this.collectPayments = collectPayments;
    }
}
