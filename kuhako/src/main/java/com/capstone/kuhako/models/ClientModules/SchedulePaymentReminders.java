package com.capstone.kuhako.models.ClientModules;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "schedulePaymentReminders")
public class SchedulePaymentReminders {
    @Id
    @GeneratedValue
    private int schedulePaymentReminders_id;

    @Column
    private PaymentDues paymentDues;

    @Column
    private Date collectionDate;

    @Column
    private long productTypeID;

    @Column
    private String reminderTitle;

    @Column
    private Date reminderDate;

    public SchedulePaymentReminders() {
    }
    public SchedulePaymentReminders(PaymentDues paymentDues, Date collectionDate, long productTypeID, String reminderTitle, Date reminderDate) {
        this.paymentDues = paymentDues;
        this.collectionDate = collectionDate;
        this.productTypeID = productTypeID;
        this.reminderTitle = reminderTitle;
        this.reminderDate = reminderDate;
    }

    public int getSchedulePaymentReminders_id() {
        return schedulePaymentReminders_id;
    }

    public PaymentDues getPaymentDues() {
        return paymentDues;
    }

    public void setPaymentDues(PaymentDues paymentDues) {
        this.paymentDues = paymentDues;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public long getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(long productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getReminderTitle() {
        return reminderTitle;
    }

    public void setReminderTitle(String reminderTitle) {
        this.reminderTitle = reminderTitle;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }
}