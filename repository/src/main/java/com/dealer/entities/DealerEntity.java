package com.dealer.entities;

import javax.persistence.*;

@Entity
@Table(name = "DealerEntity")
@NamedQuery(name="DealerEntity.findDealer", query = "Select d from DealerEntity d where d.dealerName LIKE :name")
public class DealerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DEALER_NAME")
    private String dealerName;

    @Column(name = "DEALER_PASSWORD")
    private String dealerPassword;


    public DealerEntity() {
        this.id = -1;
    }

    public DealerEntity(String dealerName, String dealerPassword) {
        this.dealerName = dealerName;
        this.dealerPassword = dealerPassword;
    }

    public DealerEntity(String dealerName, String dealerPassword, int id) {
        this.id = id;
        this.dealerPassword = dealerPassword;
        this.dealerName = dealerName;
    }

    public void setDealerEntityName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerEntityPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    public void setEntityId(int id) {
        this.id = id;
    }

    public String getDealerEntityName() {
        return dealerName;
    }

    public String getDealerEntityPassword() {
        return dealerPassword;
    }

    public int getEntityId() {
        return id;
    }
}