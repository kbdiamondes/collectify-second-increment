package com.capstone.kuhako.models.CollectorModules;

import com.capstone.kuhako.models.User;

import javax.persistence.*;

@Entity
@Table(name = "sendFollowUp")
public class SendFollowUp {
    @Id
    @GeneratedValue
    private int sendFollowUp_id;

    @Column
    private User user;

    @Column
    private String paymentStatus;

    @Column
    private String reminderMessage;

    public SendFollowUp() {
    }
    public SendFollowUp(User user, String paymentStatus, String reminderMessage) {
        this.user = user;
        this.paymentStatus = paymentStatus;
        this.reminderMessage = reminderMessage;
    }

    public int getSendFollowUp_id() {
        return sendFollowUp_id;
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

    public String getReminderMessage() {
        return reminderMessage;
    }

    public void setReminderMessage(String reminderMessage) {
        this.reminderMessage = reminderMessage;
    }
}
