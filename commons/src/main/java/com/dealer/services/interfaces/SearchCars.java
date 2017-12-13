package com.dealer.services.interfaces;

import com.dealer.dto.Car;

import javax.ejb.Remote;
import java.util.Date;
import java.util.List;

@Remote
public interface SearchCars {
    List<Car> getCars();
    List<Car> filterCars(String name, String mark, String condition, String price, Date date, String color);
}
