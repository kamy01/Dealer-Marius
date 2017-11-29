package com.dealer.beans;

import com.dealer.services.interfaces.Login;
import com.dealer.utils.Utils;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@ManagedBean
@SessionScoped

public class LoginBean implements Serializable {

    @EJB
    private Login login;

    private int requestCode;

    private String dealerName;
    private String dealerPassword;
    private UIComponent loginBtn;

    public LoginBean(){}

    public void checkLogIn(){
        requestCode = login.getResponseCode(dealerName, dealerPassword);

        FacesMessage unauthorizedMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,Utils.LOGIN_UNAUTHORIZED_MESSAGE,
                Utils.LOGIN_UNAUTHORIZED_MESSAGE);

        FacesMessage notFoundMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,Utils.LOGIN_NOT_FOUND_MESSAGE,
                Utils.LOGIN_NOT_FOUND_MESSAGE);

        FacesContext context = FacesContext.getCurrentInstance();
        switch (requestCode){
            case Utils.NOT_FOUND:
                context.addMessage(loginBtn.getClientId(context), notFoundMsg);
                break;
            case Utils.UNAUTHORIZED:
                context.addMessage(loginBtn.getClientId(context), unauthorizedMsg);
                break;
        }

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

    public UIComponent getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(UIComponent loginBtn) {
        this.loginBtn = loginBtn;
    }
}
