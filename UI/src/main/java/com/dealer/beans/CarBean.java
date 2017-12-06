package com.dealer.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import java.io.Serializable;
import java.util.Date;

@ManagedBean
@NoneScoped
public class CarBean implements Serializable{

    private String name;
    private String mark;
    private String color;
    private String condition;

    private String price;
    private Date registrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getMark() {
        return mark;
    }

    void setMark(String mark) {
        this.mark = mark;
    }

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }

    String getCondition() {
        return condition;
    }

    void setCondition(String condition) {
        this.condition = condition;
    }

    String getPrice() {
        return price;
    }

    void setPrice(String price) {
        this.price = price;
    }

    Date getRegistrationDate() {
        return registrationDate;
    }

    void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
