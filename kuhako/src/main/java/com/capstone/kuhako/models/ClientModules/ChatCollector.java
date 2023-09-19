package com.capstone.kuhako.models.ClientModules;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.CollectorModules.PaymentAssurance;

import javax.persistence.*;

@Entity
@Table(name = "chatCollector")
public class ChatCollector {
    @Id
    @GeneratedValue
    private int chatCollector_id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;

    @Column
    private PaymentAssurance paymentAssurance;

    @Column
    private String clientMessage;

    public ChatCollector() {
    }
    public ChatCollector(PaymentAssurance paymentAssurance, String clientMessage) {
        this.paymentAssurance = paymentAssurance;
        this.clientMessage = clientMessage;
    }

    public int getChatCollector_id() {
        return chatCollector_id;
    }

    public PaymentAssurance getPaymentAssurance() {
        return paymentAssurance;
    }

    public void setPaymentAssurance(PaymentAssurance paymentAssurance) {
        this.paymentAssurance = paymentAssurance;
    }

    public String getClientMessage() {
        return clientMessage;
    }

    public void setClientMessage(String clientMessage) {
        this.clientMessage = clientMessage;
    }
}
