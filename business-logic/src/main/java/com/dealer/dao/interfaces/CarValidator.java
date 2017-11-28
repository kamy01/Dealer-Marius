package com.dealer.dao.interfaces;

import com.dealer.dto.Car;
import com.dealer.entities.CarEntity;

import java.util.Date;

public interface CarValidator {
    Car getCarFromCarEntity(CarEntity carEntity);
    Car findCar(Car car);
    boolean createCar(String name, String mark, String color, String price, String condition, Date date);
}
