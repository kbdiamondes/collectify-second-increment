package com.capstone.kuhako.models.ResellerModule;

import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;

import javax.persistence.*;

@Entity
@Table(name = "assignCollectors")
public class AssignCollectors {
    @Id
    @GeneratedValue
    private Long assignCollectors_id;

    @ManyToOne
    @JoinColumn(name="reseller_id", nullable = false)
    private Reseller reseller;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    @Column
    private boolean availabilityStatus;

    public AssignCollectors() {
    }

    public AssignCollectors(Reseller reseller, Collector collector, boolean availabilityStatus) {
        this.reseller = reseller;
        this.collector = collector;
        this.availabilityStatus = availabilityStatus;
    }

    public Long getAssignCollectors_id() {
        return assignCollectors_id;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }
}
