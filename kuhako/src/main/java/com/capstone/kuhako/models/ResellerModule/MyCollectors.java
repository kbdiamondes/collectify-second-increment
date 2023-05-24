package com.capstone.kuhako.models.ResellerModule;

import javax.persistence.*;


@Entity
@Table(name = "mycollectors")
public class MyCollectors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mycollectors_id")
    private int myCollectorsId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user;

    @Column(name = "collection_status")
    private String collectionStatus;

    @Column(name = "availability_status")
    private String availabilityStatus;

    @Column(name = "required_collectibles")
    private double requiredCollectibles;

    public MyCollectors() {
    }

    public MyCollectors(String collectionStatus, String availabilityStatus, Double requiredCollectibles) {
        this.collectionStatus = collectionStatus;
        this.availabilityStatus = availabilityStatus;
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

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
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
