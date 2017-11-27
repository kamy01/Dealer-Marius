package com.dealer.beans;

import com.dealer.services.interfaces.Login;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

@ManagedBean
@RequestScoped

public class LoginBean implements Serializable {

    @EJB
    private Login login;

    private int requestCode;

    private String dealerName;
    private String dealerPassword;

    public LoginBean(){}

    public void checkLogIn(){
        requestCode = login.getResponseCode(dealerName, dealerPassword);

    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public void setDealerPassword(String dealerPassword){
        this.dealerPassword = dealerPassword;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerPassword(){
        return dealerPassword;
    }

    public int getRequestCode(){return requestCode;}

}
