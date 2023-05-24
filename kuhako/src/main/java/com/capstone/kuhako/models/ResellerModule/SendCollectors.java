package com.capstone.kuhako.models.ResellerModule;

import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;

import javax.persistence.*;

    @Entity
    @Table(name = "sendCollectors")
    public class SendCollectors {
        @Id
        @GeneratedValue
        private int sendCollector_id;

        @Column
        private double paymentDues;

        @OneToOne
        @JoinColumn
        private Reseller reseller;

        @ManyToOne
        @JoinColumn(name="collector_id", nullable = false)
        private Collector collector;

        public SendCollectors() {
        }

        public SendCollectors(Reseller reseller, double paymentDues) {
            this.reseller = reseller;
            this.paymentDues = paymentDues;
        }

        public int getSendCollector_id() {
            return sendCollector_id;
        }

        public Reseller getReseller() {
            return reseller;
        }

        public void setReseller(Reseller reseller) {
            this.reseller = reseller;
        }

        public double getPaymentDues() {
            return paymentDues;
        }

        public void setPaymentDues(double paymentDues) {
            this.paymentDues = paymentDues;
        }
}
