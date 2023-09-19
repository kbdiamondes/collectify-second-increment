package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.Collector;

import javax.persistence.*;

@Entity
@Table(name = "paymentAssurance")
public class PaymentAssurance {
    @Id
    @GeneratedValue
    private int paymentAssurance_id;

    @Column
    private Collector collector;

    @Column
    private String paymentStatus;

    public PaymentAssurance() {
    }
    public PaymentAssurance(Collector collector, String paymentStatus) {
        this.collector = collector;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentAssurance_id() {
        return paymentAssurance_id;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
