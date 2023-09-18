package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.User;

import javax.persistence.*;

@Entity
@Table(name = "paymentAssurance")
public class PaymentAssurance {
    @Id
    @GeneratedValue
    private int paymentAssurance_id;

    @Column
    private User user;

    @Column
    private String paymentStatus;

    public PaymentAssurance() {
    }
    public PaymentAssurance(User user, String paymentStatus) {
        this.user = user;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentAssurance_id() {
        return paymentAssurance_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
