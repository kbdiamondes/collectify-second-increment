package com.capstone.kuhako.models.JoinModule;


import com.capstone.kuhako.models.Collector;
import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue
    private Long transactions_id;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    @ManyToOne
    @JoinColumn(name="contracts_id", nullable = false)
    private Contracts contracts;

    @Column
    private double amountPayments;

    @Lob
    @Column(name = "transaction_proof", columnDefinition="LONGBLOB")
    private byte[] transactionProof;


    public Transactions() {
    }
    public Transactions(Collector collector, Contracts contracts, double amountPayments, byte[] transactionProof) {
        this.collector = collector;
        this.contracts = contracts;
        this.amountPayments = amountPayments;
        this.transactionProof = transactionProof;
    }

    public Long getTransactions_id() {
        return transactions_id;
    }

//    public void setTransactions_id(Long transactions_id) {
//        this.transactions_id = transactions_id;
//    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
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
