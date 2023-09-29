package com.capstone.kuhako.models.JoinModule;

import javax.persistence.*;

@Entity
@Table(name = "contractsCollector")
public class ContractsCollector {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String username;
    @Column
    private double totalAmountPaid;

    public ContractsCollector() {
    }
    public ContractsCollector(String username, double totalAmountPaid) {
        this.username = username;
        this.totalAmountPaid = totalAmountPaid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(double totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }
}
