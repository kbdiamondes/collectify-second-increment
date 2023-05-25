package com.capstone.kuhako.models.ResellerModule;

import com.capstone.kuhako.models.Client;
import com.capstone.kuhako.models.Collector;
import com.capstone.kuhako.models.Reseller;

import javax.persistence.*;


@Entity
@Table(name = "mycollectors")
public class MyCollectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mycollectors_id")
    private int myCollectorsId;

    @Column(name = "collection_status")
    private String collectionStatus;

    @Column(name = "required_collectibles")
    private double requiredCollectibles;

    @ManyToOne
    @JoinColumn(name="reseller_id", nullable = false)
    private Reseller reseller;

    @ManyToOne
    @JoinColumn(name="collector_id", nullable = false)
    private Collector collector;

    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    private Client client;


    public MyCollectors() {
    }

    public MyCollectors(String collectionStatus, Double requiredCollectibles) {
        super();
        this.collectionStatus = collectionStatus;
        this.requiredCollectibles = requiredCollectibles;
    }

    public int getMyCollectorsId() {
        return myCollectorsId;
    }

    public String getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(String collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public double getRequiredCollectibles() {
        return requiredCollectibles;
    }

    public void setRequiredCollectibles(double requiredCollectibles) {
        this.requiredCollectibles = requiredCollectibles;
    }

//    public String getUserFullName() {
//        if (user != null) {
//            return user.getFullName();
//        }
//        return null;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
