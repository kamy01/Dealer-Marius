package com.dealer.services.impl;

import com.dealer.dao.interfaces.CarValidator;
import com.dealer.dto.Car;
import com.dealer.dao.impl.CarDaoImpl;
import com.dealer.entities.CarEntity;

import java.util.Date;

public class AddCarValidatorServiceImpl implements CarValidator {


    private CarDaoImpl carDao;

    AddCarValidatorServiceImpl(){

        carDao = new CarDaoImpl();
    }

    @Override
    public Car getCarFromCarEntity(CarEntity carEntity) {
        return new Car(carEntity.getName(), carEntity.getMark(), carEntity.getCondition(), carEntity.getColor(),
                carEntity.getPrice(), carEntity.getRegistrationDate());
    }

    @Override
    public Car findCar(Car car) {
        CarEntity foundCar = carDao.getCarEntity(car.getId());
        return getCarFromCarEntity(foundCar);
    }

    @Override
    public boolean createCar(String name, String mark, String color, String price, String condition, Date date) {
        boolean isCreated;

        isCreated = carDao.createCarEntity(name, mark, color, price, condition, date);
        return isCreated;
    }
}
