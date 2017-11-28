package com.dealer.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CarEntity")
public class CarEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CAR_OWNER_ID")
    private int ownerId;

    @Column(name = "CAR_NAME")
    private String name;

    @Column(name = "CAR_MARK")
    private String mark;

    @Column(name = "CAR_COLOR")
    private String color;

    @Column(name = "CAR_CONDITION")
    private String condition;

    @Column(name = "CAR_REGISTRATION_DATE")
    private Date registrationDate;

    public CarEntity(){
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}