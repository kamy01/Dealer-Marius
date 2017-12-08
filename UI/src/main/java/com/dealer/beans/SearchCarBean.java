package com.dealer.beans;

import com.dealer.dto.Car;
import com.dealer.services.interfaces.SearchCars;
import com.dealer.utils.Utils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class SearchCarBean {

    @ManagedProperty(value = "#{carBean}")
    private CarBean carBean;

    private List<Car> cars;
    private ArrayList<String> colors, conditions;

    @EJB
    private SearchCars allCarsService;

    @PostConstruct
    public void init(){
        cars = allCarsService.getCars();
        colors = Utils.Colors.getColors();
        conditions = Utils.Conditions.getConditions();
    }

    public CarBean getCarBean() {
        return carBean;
    }

    public void setCarBean(CarBean carBean) {
        this.carBean = carBean;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<String> conditions) {
        this.conditions = conditions;
    }


}
