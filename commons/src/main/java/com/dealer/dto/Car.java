package com.dealer.dto;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private String name;
    private String mark;
    private String condition;
    private Date registrationDate;
    private String color;
    private String price;

    private int id;

    public Car(String name, String mark, String color, String price, String condition, Date registrationDate){
        this.name = name;
        this.mark = mark;
        this.condition = condition;
        this.color = color;
        this.price = price;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
