package com.capstone.kuhako.models.ResellerModule;

import com.capstone.kuhako.models.Client;
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

        @Column(name = "availability_status")
        private String availabilityStatus;

        @ManyToOne
        @JoinColumn(name="reseller_id", nullable = false)
        private Reseller reseller;

        @ManyToOne
        @JoinColumn(name="collector_id", nullable = false)
        private Collector collector;

        @ManyToOne
        @JoinColumn(name="client_id", nullable = false)
        private Client client;

        public SendCollectors() {
        }

        public SendCollectors(int sendCollector_id, double paymentDues, Reseller reseller, Collector collector, Client client) {
            this.sendCollector_id = sendCollector_id;
            this.paymentDues = paymentDues;
            this.reseller = reseller;
            this.collector = collector;
            this.client = client;
        }

        public void setSendCollector_id(int sendCollector_id) {
            this.sendCollector_id = sendCollector_id;
        }

        public Collector getCollector() {
            return collector;
        }

        public void setCollector(Collector collector) {
            this.collector = collector;
        }

        public Client getClient() {
            return client;
        }

        public void setClient(Client client) {
            this.client = client;
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
