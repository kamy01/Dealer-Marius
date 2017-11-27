package com.dealer.beans;

import com.dealer.services.interfaces.Register;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped

public class RegisterBean implements Serializable {

    private String dealerName;
    private String dealerPassword;
    private boolean isCreated;

    @EJB
    private Register register;

    public RegisterBean(){

    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPassword(String dealerPassword) {
        this.dealerPassword = dealerPassword;
    }

    public void createDealer(){
        isCreated = register.isCreated(dealerName, dealerPassword);
    }

    public String getDealerName(){
        return dealerName;
    }

    public String getDealerPassword(){
        return dealerPassword;
    }

    public boolean getIsCreated(){return isCreated;}
}