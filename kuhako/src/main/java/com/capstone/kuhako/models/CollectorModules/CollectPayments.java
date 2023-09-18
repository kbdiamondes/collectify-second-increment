package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "collectPayments")
public class CollectPayments {
    @Id
    @GeneratedValue
    private int collectPayments_id;

    @Column
    private User user;

    @Column
    private Date collectionDate;

    @Column
    private Double requiredCollectibles;

    @Column
    private Double itemCollectible;

    @Column
    private String paymentType;

    @Column
    private String transactionProof;

    public CollectPayments() {
    }
    public CollectPayments(User user, Date collectionDate, Double requiredCollectibles, Double itemCollectible, String paymentType, String transactionProof) {
        this.user = user;
        this.collectionDate = collectionDate;
        this.requiredCollectibles = requiredCollectibles;
        this.itemCollectible = itemCollectible;
        this.paymentType = paymentType;
        this.transactionProof = transactionProof;
    }

    public int getCollectPayments_id() {
        return collectPayments_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Double getRequiredCollectibles() {
        return requiredCollectibles;
    }

    public void setRequiredCollectibles(Double requiredCollectibles) {
        this.requiredCollectibles = requiredCollectibles;
    }

    public Double getItemCollectible() {
        return itemCollectible;
    }

    public void setItemCollectible(Double itemCollectible) {
        this.itemCollectible = itemCollectible;
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