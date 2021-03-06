package com.dealer.entities;

import com.dealer.dto.Car;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CarEntity")
@NamedQueries({

        @NamedQuery(name="CarEntity.findCar", query = "Select c from CarEntity c where c.id = :id"),
        @NamedQuery(name="CarEntity.getAllCars", query = "Select c from CarEntity  c"),
        @NamedQuery(name="CarEntity.filterCars", query = "Select c from CarEntity  c where c.name LIKE :name and " +
                "c.mark LIKE :mark and c.price LIKE :price and c.condition LIKE :condition and c.color LIKE :color and " +
                "c.registrationDate <=:registrationDate")})

public class CarEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "CAR_NAME")
    private String name;

    @Column(name = "CAR_MARK")
    private String mark;

    @Column(name = "CAR_PRICE")
    private String price;

    @Column(name = "CAR_COLOR")
    private String color;

    @Column(name = "CAR_CONDITION")
    private String condition;

    @Column(name = "CAR_REGISTRATION_DATE")
    private Date registrationDate;

    @Column(name= "CAR_VID")
    private int vid;

    public CarEntity(){

    }
    public CarEntity(String name, String mark, String color, String price, String condition, Date date){
        this.name = name;
        this.mark = mark;
        this.condition = condition;
        this.color = color;
        this.price = price;
        this.registrationDate = date;
    }

    public CarEntity(String name, String mark, String color, String price, String condition, Date date, int vid){
        this.name = name;
        this.mark = mark;
        this.color = color;
        this.price = price;
        this.condition = condition;
        this.registrationDate = date;
        this.vid = vid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }
}