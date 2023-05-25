package com.capstone.kuhako.models.ClientModules;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactionDetails")
public class TransactionDetails {
    @Id
    @GeneratedValue
    private int transactionDetails_id;

    @Column
    private double monthlyCollectible;

    @Column
    private double fullCashPrice;

    @Column
    private double interestRate;

    @Column
    private Date dueDate;

    @Column
    private double totalPayment;

    public TransactionDetails() {
    }
    public TransactionDetails(double monthlyCollectible, double fullCashPrice, double interestRate, Date dueDate, double totalPayment) {
        this.monthlyCollectible = monthlyCollectible;
        this.fullCashPrice = fullCashPrice;
        this.interestRate = interestRate;
        this.dueDate = dueDate;
        this.totalPayment = totalPayment;
    }

    public int getTransactionDetails_id() {
        return transactionDetails_id;
    }

    public double getMonthlyCollectible() {
        return monthlyCollectible;
    }

    public void setMonthlyCollectible(double monthlyCollectible) {
        this.monthlyCollectible = monthlyCollectible;
    }

    public double getFullCashPrice() {
        return fullCashPrice;
    }

    public void setFullCashPrice(double fullCashPrice) {
        this.fullCashPrice = fullCashPrice;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }
}
