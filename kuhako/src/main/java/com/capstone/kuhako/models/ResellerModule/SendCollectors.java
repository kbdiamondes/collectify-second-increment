package com.capstone.kuhako.models.ResellerModule;

import com.capstone.kuhako.models.Reseller;

import javax.persistence.*;
    @Entity
    @Table(name = "sendCollectors")
    public class SendCollectors {
        @Id
        @GeneratedValue
        private Long sendCollector_id;

        @Column
        private double paymentDues;

        @ManyToOne
        @JoinColumn(name="reseller_id", nullable = false)
        private Reseller reseller;

        /*@ManyToOne
        @JoinColumn(name="collector_id", nullable = false)
        private Collector collector;

        @ManyToOne
        @JoinColumn(name="client_id", nullable = false)
        private Client client;
*/
        @Column
        private int collectorsid;
        @Column
        private int clientsid;


        public SendCollectors() {
        }

        public SendCollectors(Long sendCollector_id, double paymentDues, int collectorsid, int clientsid) {
            this.sendCollector_id = sendCollector_id;
            this.paymentDues = paymentDues;
            this.collectorsid = collectorsid;
            this.clientsid = clientsid;
        }

        public int getCollectorsid() {
            return collectorsid;
        }

        public void setCollectorsid(int collectorsid) {
            this.collectorsid = collectorsid;
        }

        public int getClientsid() {
            return clientsid;
        }

        public void setClientsid(int clientsid) {
            this.clientsid = clientsid;
        }

        public void setSendCollector_id(long sendCollector_id) {
            this.sendCollector_id = sendCollector_id;
        }

    /*    public Collector getCollector() {
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
        }*/

        public Long getSendCollector_id() {
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
