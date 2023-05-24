package com.capstone.kuhako.models.ResellerModule;

import javax.persistence.*;

@Entity
@Table(name = "assignCollectors")
public class AssignCollectors {
    @Id
    @GeneratedValue
    private int assignCollectors_id;

    @Column
    private MyCollectors mycollectors;

    public AssignCollectors() {
    }

    public AssignCollectors(MyCollectors mycollectors) {
        this.mycollectors = mycollectors;
    }

    public int getAssignCollectors_id() {
        return assignCollectors_id;
    }

    public MyCollectors getCollectors() {
        return mycollectors;
    }

    public void setCollectors(MyCollectors mycollectors) {
        this.mycollectors = mycollectors;
    }
}
