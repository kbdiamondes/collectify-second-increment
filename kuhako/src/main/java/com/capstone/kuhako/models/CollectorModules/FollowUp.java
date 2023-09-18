package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.User;

import javax.persistence.*;

@Entity
@Table(name = "followUp")
public class FollowUp {
    @Id
    @GeneratedValue
    private int followUp_id;

    @Column
    private User user;

    @Column
    private String paymentStatus;

    public FollowUp() {
    }
    public FollowUp(User user, String paymentStatus) {
        this.user = user;
        this.paymentStatus = paymentStatus;
    }

    public int getFollowUp_id() {
        return followUp_id;
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
