package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.ClientModules.PayDues;

import javax.persistence.*;

@Entity
@Table(name = "collectorCollectionRecords")
public class collectorCollectionRecords {
    @Id
    @GeneratedValue
    private int collectorCollectionRecords_id;

    @Column
    private PayDues payDues;

    @Column
    private CollectPayments collectPayments;

    public collectorCollectionRecords() {
    }
    public collectorCollectionRecords(PayDues payDues, CollectPayments collectPayments) {
        this.payDues = payDues;
        this.collectPayments = collectPayments;
    }

    public int getCollectorCollectionRecords_id() {
        return collectorCollectionRecords_id;
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
