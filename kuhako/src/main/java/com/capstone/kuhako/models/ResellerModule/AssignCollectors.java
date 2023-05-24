package com.capstone.kuhako.models.ResellerModule;

import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;

import javax.persistence.*;

@Entity
@Table(name = "assignCollectors")
public class AssignCollectors {
    @Id
    @GeneratedValue
    private int assignCollectors_id;

    @ManyToOne
    @JoinColumn(name="reseller_id", nullable = false)
    private Reseller reseller;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    public AssignCollectors() {
    }

    public AssignCollectors(int assignCollectors_id, Reseller reseller, Collector collector) {
        this.assignCollectors_id = assignCollectors_id;
        this.reseller = reseller;
        this.collector = collector;
    }

    public int getAssignCollectors_id() {
        return assignCollectors_id;
    }

    public void setAssignCollectors_id(int assignCollectors_id) {
        this.assignCollectors_id = assignCollectors_id;
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
}
