package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.ClientModules.ChatCollector;

import javax.persistence.*;

@Entity
@Table(name = "paymentAssuranceMessage")
public class PaymentAssuranceMessage {
    @Id
    @GeneratedValue
    private int paymentAssuranceMessage_id;

    @Column
    private String collectorMessage;

    @Column
    private ChatCollector chatCollector;

    public PaymentAssuranceMessage() {
    }
    public PaymentAssuranceMessage(String collectorMessage, ChatCollector chatCollector) {
        this.collectorMessage = collectorMessage;
        this.chatCollector = chatCollector;
    }

    public int getPaymentAssuranceMessage_id() {
        return paymentAssuranceMessage_id;
    }

    public String getCollectorMessage() {
        return collectorMessage;
    }

    public void setCollectorMessage(String collectorMessage) {
        this.collectorMessage = collectorMessage;
    }

    public ChatCollector getChatCollector() {
        return chatCollector;
    }

    public void setChatCollector(ChatCollector chatCollector) {
        this.chatCollector = chatCollector;
    }
}
