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
    @JoinColumn(name="contracts_id")
    private Contracts contracts;

    @ManyToOne
    @JoinColumn(name="contractsHistory_id")
    private ContractsHistory contractsHistory;


    @Column
    private double amountPayments;
    @Column
    private String paymentType;

    @Lob
    @Column(name = "transaction_proof", columnDefinition="LONGBLOB")
    private byte[] transactionProof;


    public Transactions() {
    }


    public Transactions(Collector collector, Contracts contracts, ContractsHistory contractsHistory, double amountPayments, String paymentType, byte[] transactionProof) {
        this.collector = collector;
        this.contracts = contracts;
        this.contractsHistory = contractsHistory;
        this.amountPayments = amountPayments;
        this.paymentType = paymentType;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public byte[] getTransactionProof() {
        return transactionProof;
    }

    public void setTransactionProof(byte[] transactionProof) {
        this.transactionProof = transactionProof;
    }


    public ContractsHistory getContractsHistory() {
        return contractsHistory;
    }

    public void setContractsHistory(ContractsHistory contractsHistory) {
        this.contractsHistory = contractsHistory;
    }
}
