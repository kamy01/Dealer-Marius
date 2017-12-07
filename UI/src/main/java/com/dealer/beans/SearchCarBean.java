package com.dealer.beans;

import com.dealer.dto.Car;
import com.dealer.services.interfaces.SearchCars;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class SearchCarBean {

    @ManagedProperty(value = "#{carBean}")
    private CarBean carBean;

    private List<Car> cars;

    @EJB
    private SearchCars allCarsService;

    @PostConstruct
    public void init(){
        cars = allCarsService.getCars();
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
}
