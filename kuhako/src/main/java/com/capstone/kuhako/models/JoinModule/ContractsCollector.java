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
    private double debtRemaining;

    public ContractsCollector() {
    }
    public ContractsCollector(String username, double debtRemaining) {
        this.username = username;
        this.debtRemaining = debtRemaining;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getDebtRemaining() {
        return debtRemaining;
    }

    public void setDebtRemaining(double debtRemaining) {
        this.debtRemaining = debtRemaining;
    }
}
