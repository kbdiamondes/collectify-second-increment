package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.Collector;

import javax.persistence.*;

@Entity
@Table(name = "followUp")
public class FollowUp {
    @Id
    @GeneratedValue
    private int followUp_id;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    @Column
    private String paymentStatus;

    public FollowUp() {
    }
    public FollowUp(Collector collector, String paymentStatus) {
        this.collector = collector;
        this.paymentStatus = paymentStatus;
    }

    public int getFollowUp_id() {
        return followUp_id;
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
