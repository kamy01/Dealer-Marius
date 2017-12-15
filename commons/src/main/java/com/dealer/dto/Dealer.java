package com.dealer.dto;

import java.io.Serializable;

public class Dealer implements Serializable {
    private String dealerName;
    private String dealerPassword;
    private String role;
    private int id;

    public Dealer(){
        this.id = -1;
    }

    public Dealer(String dealerName, String dealerPassword, String role){
        this.dealerName = dealerName;
        this.dealerPassword = dealerPassword;
        this.role = role;
    }

    public Dealer(String dealerName, String dealerPassword){
        this.dealerName = dealerName;
        this.dealerPassword = dealerPassword;
    }

    public Dealer(String dealerName, String dealerPassword, String role, int id){
        this.id = id;
        this.dealerPassword = dealerPassword;
        this.dealerName = dealerName;
        this.role = role;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPassword(String dealerPassword){
        this.dealerPassword = dealerPassword;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getDealerName(){
        return dealerName;
    }

    public String getDealerPassword(){
        return dealerPassword;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
