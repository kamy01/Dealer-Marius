package com.dealer.beans;

import com.dealer.services.interfaces.AddCar;
import com.dealer.utils.Utils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean
@ViewScoped
public class CarBean implements Serializable{
    private String name;
    private String mark;
    private String color;
    private String condition;

    private String price;
    private Date registrationDate;

    private ArrayList<String> colors;

    private boolean isAdded = false;
    private UIComponent addBtn;

    @EJB
    private AddCar addCarService;

    @PostConstruct
    public void init(){

        colors = new ArrayList<String>();
        colors.add("White");
        colors.add("Black");
        colors.add("Blue");
        colors.add("Red");
        colors.add("Brown");
        colors.add("Green");
        colors.add("Pink");
        colors.add("Yellow");
        colors.add("Silver");
        colors.add("Grey");
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void addCar(){

        isAdded = addCarService.isCarAdded(name, mark, color, price, condition, registrationDate);
        FacesMessage successAdd = new FacesMessage(FacesMessage.SEVERITY_INFO,Utils.ADD_CAR_SUCCESSFUL_MESSAGE,
                Utils.ADD_CAR_SUCCESSFUL_MESSAGE);

        FacesMessage failAdd = new FacesMessage(FacesMessage.SEVERITY_ERROR,Utils.ADD_CAR_FAIL_MESSAGE,
                Utils.ADD_CAR_FAIL_MESSAGE);

        FacesContext context = FacesContext.getCurrentInstance();
        if(isAdded){
            context.addMessage(addBtn.getClientId(context), successAdd);
        }
        else{
            context.addMessage(addBtn.getClientId(context), failAdd);
        }
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public String getColor() {
        return color;
    }

    public String getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public UIComponent getAddBtn() {
        return addBtn;
    }

    
    public void setAddBtn(UIComponent addBtn) {
        this.addBtn = addBtn;
    }
}
