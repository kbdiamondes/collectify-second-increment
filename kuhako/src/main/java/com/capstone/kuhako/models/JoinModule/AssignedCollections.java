package com.capstone.kuhako.models.JoinModule;


import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;
import javax.persistence.*;
@Entity
@Table(name = "assignedCollection")
public class AssignedCollections {
    @Id
    @GeneratedValue
    private Long assignedCollection_id;

    @ManyToOne
    @JoinColumn(name="reseller_id", nullable = false)
    private Reseller reseller;

    @OneToOne
    @JoinColumn(name="contract_id", nullable = false)
    private Contracts contracts;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    @Column
    private double amountPayments;

    @Lob
    @Column(name = "transaction_proof", columnDefinition="BLOB")
    private byte[] transactionProof;


    public AssignedCollections() {
    }

    public AssignedCollections(Reseller reseller, Contracts contracts, Collector collector, double amountPayments, byte[] transactionProof) {
        this.reseller = reseller;
        this.contracts = contracts;
        this.collector = collector;
        this.amountPayments = amountPayments;
        this.transactionProof = transactionProof;
    }

    public Long getAssignedCollection_id() {
        return assignedCollection_id;
    }

    /*public void setAssignedCollection_id(Long assignedCollection_id) {
        this.assignedCollection_id = assignedCollection_id;
    }*/

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public double getAmountPayments() {
        return amountPayments;
    }

    public void setAmountPayments(double amountPayments) {
        this.amountPayments = amountPayments;
    }

    public byte[] getTransactionProof() {
        return transactionProof;
    }

    public void setTransactionProof(byte[] transactionProof) {
        this.transactionProof = transactionProof;
    }
}
