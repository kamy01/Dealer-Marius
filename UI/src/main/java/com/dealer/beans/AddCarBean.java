package com.dealer.beans;

import com.dealer.services.interfaces.AddCar;
import com.dealer.utils.Utils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean
@RequestScoped
public class AddCarBean implements Serializable{

    private ArrayList<String> colors;

    private boolean isAdded = false;
    private UIComponent addBtn;

    @ManagedProperty(value="#{carBean}")
    private CarBean carBean;

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

        isAdded = addCarService.isCarAdded(carBean.getName(), carBean.getMark(), carBean.getColor(), carBean.getPrice(),
                carBean.getCondition(), carBean.getRegistrationDate());

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


    public boolean isAdded() {
        return isAdded;
    }

    public UIComponent getAddBtn() {
        return addBtn;
    }


    public void setAddBtn(UIComponent addBtn) {
        this.addBtn = addBtn;
    }

    public CarBean getCarBean() {
        return carBean;
    }

    public void setCarBean(CarBean carBean) {
        this.carBean = carBean;
    }

    public String getName() {
        return carBean.getName();
    }

    public void setName(String name) {
        this.carBean.setName(name);
    }

    public String getMark() {
        return carBean.getMark();
    }

    public void setMark(String mark) {
        this.carBean.setMark(mark);
    }

    public String getColor() {
        return carBean.getColor();
    }

    public void setColor(String color) {
        this.carBean.setColor(color);
    }

    public String getCondition() {
        return carBean.getCondition();
    }

    public void setCondition(String condition) {
        this.carBean.setCondition(condition);
    }

    public String getPrice() {
        return carBean.getPrice();
    }

    public void setPrice(String price) {
        this.carBean.setPrice(price);
    }

    public Date getRegistrationDate() {
        return carBean.getRegistrationDate();
    }

    public void setRegistrationDate(Date registrationDate) {
        this.carBean.setRegistrationDate(registrationDate);
    }
}
