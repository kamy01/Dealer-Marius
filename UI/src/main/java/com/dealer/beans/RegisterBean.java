package com.dealer.beans;

import com.dealer.services.interfaces.Register;
import com.dealer.utils.Utils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean
@RequestScoped

public class RegisterBean implements Serializable {

    private String dealerName;
    private String dealerPassword;
    private String dealerRole;
    private ArrayList<String> roles;
    private boolean isCreated;
    private UIComponent registerBtn;

    @PostConstruct
    public void init(){
        roles = Utils.Roles.getRoles();
    }

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
        isCreated = register.isCreated(dealerName, dealerPassword, dealerRole);

        FacesMessage successMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,Utils.REGISTER_SUCCESS_MESSAGE,
                Utils.REGISTER_SUCCESS_MESSAGE);

        FacesMessage failedMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,Utils.REGISTER_USER_EXISTS_MESSAGE,
                Utils.REGISTER_USER_EXISTS_MESSAGE);

        FacesContext context = FacesContext.getCurrentInstance();
        if(isCreated){
            context.addMessage(registerBtn.getClientId(context), successMsg);
        }
        else{
            context.addMessage(registerBtn.getClientId(context), failedMsg);
        }
    }

    public String getDealerName(){
        return dealerName;
    }

    public String getDealerPassword(){
        return dealerPassword;
    }

    public boolean getIsCreated(){return isCreated;}

    public UIComponent getRegisterBtn() {
        return registerBtn;
    }

    public void setRegisterBtn(UIComponent registerBtn) {
        this.registerBtn = registerBtn;
    }

    public String getDealerRole() {
        return dealerRole;
    }

    public void setDealerRole(String dealerRole) {
        this.dealerRole = dealerRole;
    }

    public ArrayList<String> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<String> roles) {
        this.roles = roles;
    }
}